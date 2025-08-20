package coroutines_study.f_203_job

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val deferred: Deferred<String> = async {
        delay(1000L)
        "Test"
    }
    val job: Job = deferred
}