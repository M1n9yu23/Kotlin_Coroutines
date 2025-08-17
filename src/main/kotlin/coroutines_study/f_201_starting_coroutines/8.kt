package coroutines_study.f_201_starting_coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main() {
    println("A")
    val a: Int = coroutineScope {
        delay(1000L)
        10
    }
    println("B")
    val b: Int = coroutineScope {
        delay(1000L)
        20
    }
    println("C")
    println(a + b)
}