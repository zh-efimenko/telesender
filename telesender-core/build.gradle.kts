dependencies {
	implementation("com.konghq:unirest-java:3.11.09")
	implementation("com.konghq:unirest-objectmapper-jackson:3.11.09")
	implementation("org.hibernate:hibernate-validator:7.0.0.Final")

	// DevUtil
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	compileOnly("org.springframework.boot:spring-boot-configuration-processor")
}
