plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20240303")
    implementation("org.zeromq:jeromq:0.5.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
}

tasks.test {
    useJUnitPlatform()
}