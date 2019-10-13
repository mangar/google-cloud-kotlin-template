package webapp.secure

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get


const val HOMESECURE_PATH = "/secure"

fun Route.homeSecure() {
  get(HOMESECURE_PATH) {
    call.respondText("Home.Secure")
  }
}

