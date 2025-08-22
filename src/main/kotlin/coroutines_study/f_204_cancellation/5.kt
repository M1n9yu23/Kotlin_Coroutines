package coroutines_study.f_204_cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            repeat(1000) { i ->
                delay(200)
                println("Printing $i")
            }
        } catch(e: CancellationException) {
            println(e)
            throw e
        }
    }

    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
}