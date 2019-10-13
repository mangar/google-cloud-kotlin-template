package main.kotlin.api

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import main.kotlin.model.toJsonString
import main.kotlin.repository.SchoolRepository

const val SCHOOLS_API_PATH = "/api/v1/schools"

// TODO Add to Postman
fun Route.schoolAPI() {
  get(SCHOOLS_API_PATH) {
    call.respondText(contentType = ContentType.Application.Json) {
      val schools = SchoolRepository().listAll()
      schools.toJsonString()
    }
  }
}
