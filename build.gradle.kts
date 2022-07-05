import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("com.github.node-gradle.node") version "3.4.0"
}

group = "de.tschuehly"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<com.github.gradle.node.npm.task.NpxTask>("tailwind"){
	command.set("tailwindcss")
	args.set(listOf("-i", "./src/main/resources/static/styles.css",  "-o" ,"./src/main/resources/static/output.css", "--watch"))
}

tasks.register("sync"){
	inputs.files("./src/main/resources/static","./src/main/resources/templates",)
	doLast {
		sync {
			from("./src/main/resources/static")
			into("build/resources/main/static")
		}
		sync {
			from("./src/main/resources/templates")
			into("build/resources/main/templates")
		}

	}

}
