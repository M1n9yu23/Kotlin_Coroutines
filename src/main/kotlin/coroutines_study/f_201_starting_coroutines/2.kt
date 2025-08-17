package coroutines_study.f_201_starting_coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        delay(1000L)
        println("World")
    }
    runBlocking {
        delay(1000L)
        println("World")
    }
    runBlocking {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}