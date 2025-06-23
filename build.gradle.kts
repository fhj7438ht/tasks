plugins {
    id("java")
    id("application")
}

group = "tasks"
version = "1.0"

repositories {
    mavenCentral()
}
application {
    mainClass.set("task4_7.Main")
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}