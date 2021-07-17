package pt.cnlaert.travelservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TravelServiceApplication

fun main(args: Array<String>) {
	runApplication<TravelServiceApplication>(*args)
}
