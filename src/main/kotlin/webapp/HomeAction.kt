package webapp

import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get


const val HOME_PATH = "/"

fun Route.home() {
  get(HOME_PATH) {
    call.respond(FreeMarkerContent("home/index.ftl", null))
  }
}
