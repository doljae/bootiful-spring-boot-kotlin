package com.example.joshlong

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

@SpringBootTest
class JoshlongSpringDemoKotlinApplicationTests {

    @Test
    fun contextLoads() {
        val applicationModules = ApplicationModules.of(JoshlongSpringDemoKotlinApplication::class.java)
        println(applicationModules)

        // verify application module structure
        applicationModules.verify()

        // generate application module component diagrams
        // build/spring-modulith-docs/components.puml
        Documenter(applicationModules).writeDocumentation()
    }
}
