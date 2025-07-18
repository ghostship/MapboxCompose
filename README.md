Compose Multiplatform Mapbox View for Android, iOS.

## Installation
Artifact is currently not hosted. Install from maven local

### Publish to Maven Local
1. Download the project
2. run `./gradlew publishToMavenLocal`

### Client Project Setup
1. Create a new compose multiplatform project
2. Add repositories to project config: 
```
dependencyResolutionManagement {
    repositories {
        ...
        maven(url = "https://maven.google.com/")
        maven(url = "https://api.mapbox.com/downloads/v2/releases/maven")
        mavenLocal()
    }
}
```
3. Add dependencies to project: `implementation("com.inspiringapps.libs:library:1.0")`
4. In xcode, add the Swift Package `https://github.com/ghostship/MapboxCompose`

# Compose Multiplatform
implementation("com.inspiringapps.libs:library:1.0")