package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.*

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main() = runBlocking(CoroutineName("main")) {
    log("Started")
    val v1 = async {
        delay(500)
        log("Running async")
        42
    }
    launch {
        delay(1000)
        log("Running launch")
    }
    log("The answer is ${v1.await()}")
}