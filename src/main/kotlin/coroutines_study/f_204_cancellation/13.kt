package coroutines_study.f_204_cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        do {
            Thread.sleep(200)
            println("Printing")
        } while (this.isActive)
    }
    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
}