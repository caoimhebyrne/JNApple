plugins {
    java
    id("java-library")
    id("maven-publish")
}

group = "net.iridescentsoftware.jnapple"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api("net.java.dev.jna:jna:5.10.0")
    api("net.java.dev.jna:jna-platform:5.10.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
