package coroutines_study.f_204_cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1000)
    }

    job.invokeOnCompletion { exception: Throwable? ->
        println("Finished")
    }

    delay(400)
    job.cancelAndJoin()
}