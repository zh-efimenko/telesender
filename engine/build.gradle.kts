version = "0.0.1-SNAPSHOT"

dependencies {
	implementation(project(":core"))

	// DevUtil
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	compileOnly("org.springframework.boot:spring-boot-configuration-processor")
}
