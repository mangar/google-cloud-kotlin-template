package main.kotlin.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list


@Serializable
data class Ranking(val position: Int, val username: String, val points: Int)

fun Ranking.toJsonString(): String =
  Json.stringify(Ranking.serializer(), this)

fun List<Ranking>.toJsonString(): String =
  Json.stringify(Ranking.serializer().list, this)



