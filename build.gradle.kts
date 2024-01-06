buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = "1.9.0"))
        classpath("com.android.tools.build:gradle:8.1.3")
    }
}

allprojects {
    repositories {
        //google()
//        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}