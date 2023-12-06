dependencies {
    implementation("global.genesis:genesis-messages")
    compileOnly(project(path = ":position-app-dictionary-cache", configuration = "codeGen"))
}

description = "position-app-messages"