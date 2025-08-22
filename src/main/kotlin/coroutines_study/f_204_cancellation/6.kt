package coroutines_study.f_204_cancellation

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(Random.nextLong(2000))
            println("Done")

        } finally {
            println("Will always be printed")
        }
    }

    delay(1000)
    job.cancelAndJoin()
}