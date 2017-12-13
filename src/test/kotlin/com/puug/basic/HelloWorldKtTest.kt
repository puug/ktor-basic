package com.puug.basic

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.*

/**
 * @author Ryan Murfitt (rmurfitt@console.com.au)
 */
class HelloWorldKtTest {

    @Test
    fun `test main function`() = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/")) {
            assertEquals(io.ktor.http.HttpStatusCode.OK, response.status())
            assertEquals("Hello, Worlds!", response.content)
        }
        with(handleRequest(HttpMethod.Get, "/index.html")) {
            assertFalse(requestHandled)
        }
    }
}