plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("org.jetbrains.intellij") version "1.9.0"
    id("org.jetbrains.grammarkit") version "2021.2.2"
}

group = "co.anbora.labs"
version = "1.0"

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
    version.set("2021.3.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    val generateBrewLexer = task<org.jetbrains.grammarkit.tasks.GenerateLexerTask>("generateBrewLexer") {
        source.set("src/main/grammar/BrewBundle.flex")
        targetDir.set("src/main/gen/co/anbora/labs/brewbundle/lang/")
        targetClass.set("FirebaseRulesLexer")
        purgeOldFiles.set(true)
    }

    val generateBrewParser = task<org.jetbrains.grammarkit.tasks.GenerateParserTask>("generateBrewParser") {
        source.set("src/main/grammar/BrewBundle.bnf")
        targetRoot.set("src/main/gen")
        pathToParser.set("/co/anbora/labs/brewbundle/lang/core/parser/BrewParser.java")
        pathToPsiRoot.set("/co/anbora/labs/brewbundle/lang/core/psi")
        purgeOldFiles.set(true)
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        dependsOn(generateBrewLexer, generateBrewParser)
        kotlinOptions.jvmTarget = "11"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("222.*")
        changeNotes.set(file("src/main/html/change-notes.html").inputStream().readBytes().toString(Charsets.UTF_8))
        pluginDescription.set(file("src/main/html/description.html").inputStream().readBytes().toString(Charsets.UTF_8))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
