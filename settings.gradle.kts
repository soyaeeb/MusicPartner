pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}
rootProject.name = "MusicPartner"
include (":app")
include (":common")
include (":features")
include (":model")
include (":library")
include (":cache")
include (":helper")
include (":data")
include (":domain")
include (":features:audiomusic")
include (":features:videomusic")
include (":features:youtube")
include (":features:chat")
include (":features:credential:login")
include (":features:credential:create-account")
include (":features:profile")
include (":features:settings")
include (":features:about")
include (":features:terms-conditions")
include(":assets")
include(":navigation")
