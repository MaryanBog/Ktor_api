package ru.playzone

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import org.jetbrains.exposed.sql.Database
import ru.playzone.features.games.configureGameRouting
import ru.playzone.features.login.configureLoginRouting
import ru.playzone.features.register.configureRegisterRouting
import ru.playzone.plugins.*

fun main() {
    Database.connect("jdbc:postgresql://localhost:5432/playzone", driver = "org.postgresql.Driver", user = "postgres",
        password = "Maryan4013426")

    embeddedServer(CIO, port = 8080, host = "0.0.0.0"){
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
        configureGameRouting()
    }
        .start(wait = true)
}
