package webapp

import br.com.mangar.App
import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import main.kotlin.model.Student
import main.kotlin.repository.StudentRepository
import java.lang.IllegalArgumentException

const val STUDENTS_GET_PATH = "/students"

fun Route.student(db: StudentRepository) {
  get(STUDENTS_GET_PATH) {
    val students = db.listAll()
    call.respond(FreeMarkerContent("student/index.ftl", mapOf("students" to students)))
  }
}

const val STUDENT_POST_PATH = "/student"

fun Route.studentPOST(db: StudentRepository) {
  post(STUDENT_POST_PATH) {

    val params = call.receiveParameters()
    val name = params["name"] ?: throw IllegalArgumentException("Missing field NAME")
    val email = params["email"] ?: throw IllegalArgumentException("Missing field EMAIL")
    val username = params["username"] ?: throw IllegalArgumentException("Missing field USERNAME")
    val action = params["action"] ?: throw IllegalArgumentException("Missing field ACTION")


    val student = Student(name, email, username)
    App.logInfo(">> Student: $student")

    db.add(student)


    call.respondRedirect(STUDENTS_GET_PATH)
  }
}
