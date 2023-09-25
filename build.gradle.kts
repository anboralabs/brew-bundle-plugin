plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
    id("org.jetbrains.grammarkit") version "2022.3.1"
}

group = "co.anbora.labs"
version = "2023.2.0"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("src/main/gen")
    }
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("LATEST-EAP-SNAPSHOT")
    type.set("IU") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {

    buildSearchableOptions {
        enabled = false
    }
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    val generateBrewLexer = task<org.jetbrains.grammarkit.tasks.GenerateLexerTask>("generateBrewLexer") {
        sourceFile.set(file("src/main/grammar/BrewBundle.flex"))
        targetDir.set("src/main/gen/co/anbora/labs/brewbundle/lang/")
        targetClass.set("BrewLexer")
        purgeOldFiles.set(true)
    }

    val generateBrewParser = task<org.jetbrains.grammarkit.tasks.GenerateParserTask>("generateBrewParser") {
        sourceFile.set(file("src/main/grammar/BrewBundle.bnf"))
        targetRoot.set("src/main/gen")
        pathToParser.set("/co/anbora/labs/brewbundle/lang/core/parser/BrewParser.java")
        pathToPsiRoot.set("/co/anbora/labs/brewbundle/lang/core/psi")
        purgeOldFiles.set(true)
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        dependsOn(generateBrewLexer, generateBrewParser)
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("233")
        untilBuild.set("233.*")
        changeNotes.set(file("src/main/html/change-notes.html").inputStream().readBytes().toString(Charsets.UTF_8))
        pluginDescription.set(file("src/main/html/description.html").inputStream().readBytes().toString(Charsets.UTF_8))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
