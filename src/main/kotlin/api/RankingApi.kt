package main.kotlin.api

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import main.kotlin.model.toJsonString
import main.kotlin.repository.RankingRepository

const val RANKING_API_PATH = "/api/v1/ranking"

fun Route.rankingAPI() {
  get(RANKING_API_PATH) {
    call.respondText(contentType = ContentType.Application.Json) {
      val ranking = RankingRepository().listAll()
      ranking.toJsonString()
    }
  }
}

