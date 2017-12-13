package com.puug.basic

import kotlinx.html.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.routing.*

fun Application.htmlMain() {
//    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondHtml {
                head {
                    title { +"HTML Applications" }
                }
                body {
                    h1 { +"Sample</div>application with HTML builders" }
                    widget {
                        +"Widgets are just functions"
                    }
                }
            }
        }
    }
}

fun FlowContent.widget(body: FlowContent.() -> Unit) {
    div { body() }
}
