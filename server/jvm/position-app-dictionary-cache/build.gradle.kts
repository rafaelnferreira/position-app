
// Add your genesis config dependencies here
dependencies {
    implementation(project(":position-app-dictionary-cache:position-app-generated-dao"))
    implementation(project(":position-app-dictionary-cache:position-app-generated-fields"))
    implementation(project(":position-app-dictionary-cache:position-app-generated-hft"))
    implementation(project(":position-app-dictionary-cache:position-app-generated-sysdef"))
    implementation(project(":position-app-dictionary-cache:position-app-generated-view"))

    implementation("global.genesis:auth-config:${properties["authVersion"]}")
}

description = "position-app-dictionary-cache"
