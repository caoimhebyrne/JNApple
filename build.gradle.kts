plugins {
    java
    id("java-library")
    id("maven-publish")
}

group = "dev.caoimhe"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api("net.java.dev.jna:jna:5.12.1")
    api("net.java.dev.jna:jna-platform:5.12.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    onlyIf { environment.getOrDefault("JITPACK", "false") != "true" }
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
