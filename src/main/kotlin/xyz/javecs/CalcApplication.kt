package xyz.javecs

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CalcApplication

fun main(args: Array<String>) {
    SpringApplication.run(CalcApplication::class.java, *args)
}
