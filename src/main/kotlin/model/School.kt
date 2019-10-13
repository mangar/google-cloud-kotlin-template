package main.kotlin.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

@Serializable
data class School(val id: String, val name: String, val logo: String)

fun School.toJsonString(): String =
  Json.stringify(School.serializer(), this)

fun List<School>.toJsonString(): String =
  Json.stringify(School.serializer().list, this)




