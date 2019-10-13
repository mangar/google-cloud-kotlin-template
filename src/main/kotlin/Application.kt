package br.com.mangar

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.features.DefaultHeaders
import io.ktor.freemarker.FreeMarker
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.*
import main.kotlin.api.rankingAPI
import main.kotlin.api.schoolAPI
import main.kotlin.repository.StudentRepository
import model.User
import org.slf4j.LoggerFactory
import webapp.home
import webapp.secure.homeSecure
import webapp.student
import webapp.studentPOST

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(DefaultHeaders)

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "webapp")
    }

    install(Authentication) {
        basic(name = "auth") {
           realm = "Panorama"
            validate {credentials ->
                if (credentials.password == "password" && credentials.name == "user") User(credentials.name) else null
            }
        }
    }

    routing {
        // STATIC
        static("/static") {
          resources("static/images")
        }

        // PUBLIC
        home()
        student(StudentRepository())
        studentPOST(StudentRepository())

        // SECURE
        authenticate("auth") {
          homeSecure()
        }

        // API
        rankingAPI()
        schoolAPI()

    }

}



object App {

  val log = LoggerFactory.getLogger("Application");
  fun logInfo(message: String, group: String = "main") {
    log.info("[ $group ] $message");
  }

}

