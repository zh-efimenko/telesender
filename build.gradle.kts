import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	`maven-publish`
	`java-library`
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("kapt") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}

group = "me.eefimenko.telesender"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")

	implementation("com.konghq:unirest-java:3.11.09")
	implementation("com.konghq:unirest-objectmapper-jackson:3.11.09")
	implementation("org.hibernate:hibernate-validator:7.0.0.Final")

	// Kotlin
	implementation("io.github.microutils:kotlin-logging:1.7.8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// DevUtil
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	kapt("org.springframework.boot:spring-boot-configuration-processor")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<Jar> {
	enabled = true
}

tasks.withType<BootJar> {
	enabled = false
}

java {
	withJavadocJar()
	withSourcesJar()
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "me.eefimenko.telesender"
			artifactId = "telesender"
			version = "0.0.1-SNAPSHOT"

			from(components["java"])
		}
	}
}
