import java.net.URI

plugins {
	kotlin("jvm") version "2.1.10"
	application
}

group = "com.muliyul"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(platform("ru.vyarus.guicey:guicey-bom:7.1.4"))
	implementation("ru.vyarus:dropwizard-guicey")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("io.dropwizard:dropwizard-assets")
	implementation("io.swagger.core.v3:swagger-jaxrs2-jakarta:2.2.7")

	testImplementation("io.dropwizard:dropwizard-testing")
	testRuntimeOnly("com.h2database:h2")
	testImplementation(kotlin("test-junit5"))
}

tasks.test {
	useJUnitPlatform()
}

kotlin {
	jvmToolchain(21)
}

application {
	mainClass.set("com.muliyul.scale.ScaleServiceKt")
}
