pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Exchanger"

include(":app")
include(":domain")

include(":core")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:resource")
include(":core:ui")

include(":feature")
include(":feature:exchange")
include(":data")