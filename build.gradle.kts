import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	`maven-publish`
	id("org.springframework.boot") version "2.4.1" apply false
	id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
	kotlin("jvm") version "1.5.10" apply false
	kotlin("kapt") version "1.5.10" apply false
	kotlin("plugin.spring") version "1.5.10" apply false
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "maven-publish")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	group = "io.github.zh-efimenko"
	version = "1.1.0"
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
		manifest {
			attributes(
				mapOf(
					"Implementation-Title" to project.name,
					"Implementation-Version" to project.version
				)
			)
		}
	}

	tasks.withType<BootJar> {
		enabled = false
	}

	val sourcesJar by tasks.registering(Jar::class) {
		archiveClassifier.set("sources")
		from(sourceSets.main.get().allSource)
	}

	val javadocJar by tasks.registering(Jar::class) {
		archiveClassifier.set("javadoc")
		from(tasks["javadoc"])
	}

	publishing {
		publications {
			create<MavenPublication>("maven") {
				groupId = project.group as String
				version = project.version as String

				from(components["java"])
				artifact(sourcesJar.get())
				artifact(javadocJar.get())
			}
		}
	}

}
