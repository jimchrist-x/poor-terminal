plugins {
  java
  application
}

group = "art.stalaverse.poorterminal"
version = "1.0.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(25)
  }
}

application {
  mainClass = "art.stalaverse.poorterminal.PoorTerminal"
}

tasks.test {
  useJUnitPlatform()
}
