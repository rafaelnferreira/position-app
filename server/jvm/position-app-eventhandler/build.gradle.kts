dependencies {
    implementation("global.genesis:genesis-pal-execution")
    implementation("global.genesis:genesis-eventhandler")
    implementation(project(":position-app-messages"))
    api("global.genesis:genesis-db")
    compileOnly(project(":position-app-config"))
    compileOnly(project(path = ":position-app-dictionary-cache", configuration = "codeGen"))
    testImplementation("global.genesis:genesis-dbtest")
    testImplementation("global.genesis:genesis-testsupport")
    testImplementation(project(path = ":position-app-dictionary-cache", configuration = "codeGen"))
}

description = "position-app-eventhandler"