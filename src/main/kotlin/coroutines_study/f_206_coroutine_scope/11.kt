package coroutines_study.f_206_coroutine_scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout


suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(2000)
            println("Will not be printed")
        }
        withTimeout(1000) {
            delay(1500)
        }
    }

    launch {
        delay(2000)
        println("Done")
    }
}