plugins {
    kotlin("jvm") version "2.0.20"
    id("me.champeau.jmh") version "0.7.2"
}

group = "com.zhelenskiy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

jmh {
//    warmupIterations.set(0)
//    iterations.set(1)
//    fork.set(1)
//    timeOnIteration.set("1")
    
    benchmarkMode.set(listOf("avgt"))
    fork = 2
    timeOnIteration = "3"
    warmupIterations = 3
    timeUnit.set("ns")
}
