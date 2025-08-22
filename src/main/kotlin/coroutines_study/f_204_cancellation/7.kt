package coroutines_study.f_204_cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("Done")

        } finally {
            println("Finally")
            launch { // 무시 됨
                println("Will not be printed")
            }
            delay(1000) // 여기서 예외 발생
            println("Will not be printed")
        }
    }

    delay(1000)
    job.cancelAndJoin()
    println("Cancel done")
}