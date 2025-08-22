package coroutines_study.f_204_cancellation

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(200)
            println("Done")
        } finally {
            println("Finally")
            withContext(NonCancellable) {
                delay(1000)
                println("Cleanup done")
            }
        }
    }

    delay(100)
    job.cancelAndJoin()
    println("main function Done")
}