package ex.ample.selfreferencing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SelfReferencingEntityApplication

fun main(args: Array<String>) {
    runApplication<SelfReferencingEntityApplication>(*args)
}
