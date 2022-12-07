package ru.playzone

import io.ktor.http.*
import io.ktor.server.application.*
import kotlin.test.*
import io.ktor.server.testing.*
import ru.playzone.plugins.*

class ApplicationTest {
    @Test
    fun testRoot(){
        withTestApplication(Application::configureRouting) {
            handleRequest(HttpMethod.Get, "/test").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Test Hello World", response.content)
            }
        }
    }
}