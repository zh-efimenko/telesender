import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	`maven-publish`
	`java-library`
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
	kotlin("jvm") version "1.4.21"
	kotlin("kapt") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21" apply false
}

allprojects {
	apply(plugin = "java")
	apply(plugin = "maven-publish")
	apply(plugin = "java-library")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	group = "me.eefimenko.telesender"
	java.sourceCompatibility = JavaVersion.VERSION_11

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")

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

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
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
				groupId = project.group as String
				artifactId = project.name
				version = project.version as String

				from(components["java"])
			}
		}
	}

}
