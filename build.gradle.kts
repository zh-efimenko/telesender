import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	java
	`maven-publish`
	signing
	id("org.springframework.boot") version "2.4.1" apply false
	id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
	kotlin("jvm") version "1.5.10" apply false
	kotlin("kapt") version "1.5.10" apply false
	kotlin("plugin.spring") version "1.5.10" apply false
}

project(":telesender-core-starter") {
	description = "Low-level API for telegram bots on Kotlin."
}

project(":telesender-engine-starter") {
	description = "Starter for simplify the creation process of any telegram bots on Kotlin."
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "maven-publish")
	apply(plugin = "signing")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	group = "io.github.zh-efimenko.telesender"
	version = "1.1.1-SNAPSHOT"
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
			freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
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

	java {
		withJavadocJar()
		withSourcesJar()
	}

	publishing {
		publications {
			create<MavenPublication>("mavenKotlin") {
				from(components["java"])
				pom {
					name.set(project.name)
					description.set(project.description)
					url.set("https://zh-efimenko.github.io/telesender/")
					licenses {
						license {
							name.set("GNU General Public License, version 3")
							url.set("https://www.gnu.org/licenses/gpl-3.0.html")
						}
					}
					developers {
						developer {
							id.set("zh-efimenko")
							name.set("Yauheni Yefimenka")
							email.set("zh.efimenko@gmail.com")
						}
					}
					scm {
						connection.set("scm:git:https://github.com/zh-efimenko/telesender.git")
						developerConnection.set("scm:git:git@github.com:zh-efimenko/telesender.git")
						url.set("https://zh-efimenko.github.io/telesender/")
					}
				}
				repositories {
					maven {
						credentials(PasswordCredentials::class)
						val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
						val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
						url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
					}
				}
			}
		}
	}

	signing {
		sign(publishing.publications["mavenKotlin"])
	}

}
