plugins {
    distribution
}

dependencies {
    implementation(project(":position-app-config"))
    implementation(project(":position-app-dictionary-cache"))
    implementation(project(":position-app-eventhandler"))
    implementation(project(":position-app-messages"))
    implementation(project(":position-app-script-config"))
}

description = "position-app-distribution"

distributions {
    main {
        contents {
            // Octal conversion for file permissions
            val libPermissions = "600".toInt(8)
            val scriptPermissions = "700".toInt(8)
            into("position-app/bin") {
                from(configurations.runtimeClasspath)
                exclude("position-app-config*.jar")
                exclude("position-app-script-config*.jar")
                exclude("position-app-distribution*.jar")
                include("position-app-*.jar")
            }
            into("position-app/lib") {
                from("${project.rootProject.buildDir}/dependencies")
                duplicatesStrategy = DuplicatesStrategy.EXCLUDE

                exclude("genesis-*.jar")
                exclude("position-app-*.jar")
                exclude("*.zip")

                fileMode = libPermissions
            }
            into("position-app/cfg") {
                from("${project.rootProject.projectDir}/position-app-config/src/main/resources/cfg")
                from(project.layout.buildDirectory.dir("generated/product-details"))
                filter(
                    org.apache.tools.ant.filters.FixCrLfFilter::class,
                    "eol" to org.apache.tools.ant.filters.FixCrLfFilter.CrLf.newInstance("lf")
                )
            }
            into("position-app/scripts") {
                from("${project.rootProject.projectDir}/position-app-config/src/main/resources/scripts")
                from("${project.rootProject.projectDir}/position-app-script-config/src/main/resources/scripts")
                filter(
                    org.apache.tools.ant.filters.FixCrLfFilter::class,
                    "eol" to org.apache.tools.ant.filters.FixCrLfFilter.CrLf.newInstance("lf")
                )
                fileMode = scriptPermissions
            }
            // Removes intermediate folder called with the same name as the zip archive.
            into("/")
        }
    }
}

val distribution by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
}

// To give custom name to the distribution package
tasks {
    distZip {
        archiveBaseName.set("genesisproduct-position-app")
        archiveClassifier.set("bin")
        archiveExtension.set("zip")
    }
    copyDependencies {
        enabled = false
    }
}

artifacts {
    val distzip = tasks.distZip.get()
    add("distribution", distzip.archiveFile) {
        builtBy(distzip)
    }
}

publishing {
    publications {
        create<MavenPublication>("position-appServerDistribution") {
            artifact(tasks.distZip.get())
        }
    }
}

description = "position-app-distribution"
