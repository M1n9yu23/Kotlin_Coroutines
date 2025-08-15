package coroutines_study.`103_suspension`

import kotlinx.coroutines.delay

suspend fun a() {
    delay(1000)
    println("A")
}

suspend fun main() {
    println("Before")
    a()
    println("After")
}