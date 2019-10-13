package main.kotlin.model

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.list
import java.util.*

@Serializable
data class Student(val name: String,
                   val email: String,
                   val username: String,
                   @ContextualSerialization val createdAt: Date = Date())

fun Student.toJsonString(): String =
  Json.stringify(Student.serializer(), this)

fun List<Student>.toJsonString(): String =
  Json.stringify(Student.serializer().list, this)


