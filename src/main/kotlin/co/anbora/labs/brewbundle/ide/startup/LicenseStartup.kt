package co.anbora.labs.brewbundle.ide.startup

import co.anbora.labs.brewbundle.license.CheckLicense
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class LicenseStartup: ProjectActivity {
    override suspend fun execute(project: Project) {
        val licensed = CheckLicense.isLicensed() ?: false

        if (!licensed) {
            CheckLicense.requestLicense("Support plugin.")
        }
    }
}