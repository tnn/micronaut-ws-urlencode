plugins {
    id("io.micronaut.minimal.application") version "4.4.5"
}

version = "0.1"
group = "com.github.tnn"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut:micronaut-websocket")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.yaml:snakeyaml")

    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("jakarta.validation:jakarta.validation-api")

    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("com.github.tnn.Application")
}
java {
}


micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.github.tnn.*")
    }
}
