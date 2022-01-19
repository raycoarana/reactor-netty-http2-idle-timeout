plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.raycoarana.server"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.projectreactor.netty:reactor-netty-core:1.0.15")
    implementation("io.projectreactor.netty:reactor-netty-http:1.0.15")
    implementation("io.projectreactor.netty:reactor-netty-http:1.0.15")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.72.Final:osx-aarch_64")
}
