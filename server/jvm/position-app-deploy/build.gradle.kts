plugins {
    id("global.genesis.deploy")
}

description = "position-app-deploy"

dependencies {
    genesisServer(
        group = "global.genesis",
        name = "genesis-distribution",
        version = properties["genesisVersion"].toString(),
        classifier = "bin",
        ext = "zip"
    )
    genesisServer(
        group = "global.genesis",
        name = "auth-distribution",
        version = properties["authVersion"].toString(),
        classifier = "bin",
        ext = "zip"
    )

    genesisServer(project(":position-app-distribution", "distribution"))
    genesisServer(project(":position-app-site-specific", "distribution"))
    genesisWeb(":client")

    api(project(":position-app-eventhandler"))
    api(project(":position-app-messages"))
    // Add additional dependencies on other external distributions here
}
tasks {
    copyDependencies {
        from(configurations.getByName("genesisServer"))
    }
}
