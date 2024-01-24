plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.2.1"
    id("io.micronaut.aot") version "4.2.1"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.reactivex.rxjava3:rxjava:3.0.0")
    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.rxjava3:micronaut-rxjava3")
    implementation("io.micronaut.rxjava3:micronaut-rxjava3-http-client")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.apache.logging.log4j:log4j-api")
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.20.0"))
    runtimeOnly("org.apache.logging.log4j:log4j-core")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl")
    testImplementation("org.mockito:mockito-core")
}


application {
    mainClass.set("com.example.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}


graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    aot {
    // Please review carefully the optimizations enabled below
    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading.set(false)
        convertYamlToJava.set(false)
        precomputeOperations.set(true)
        cacheEnvironment.set(true)
        optimizeClassLoading.set(true)
        deduceEnvironment.set(true)
        optimizeNetty.set(true)
    }
}



