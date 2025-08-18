package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.*

fun main() = runBlocking(CoroutineName("main")) {
    log("Started")
    val v1 = async(CoroutineName("c1")) {
        delay(500)
        log("Running async")
        42
    }

    launch(CoroutineName("c2")) {
        delay(1000)
        log("Running launch")
    }

    log("The answer is ${v1.await()}")
}