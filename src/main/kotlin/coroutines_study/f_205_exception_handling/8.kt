package coroutines_study.f_205_exception_handling

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private object MyNonPropagatingException : CancellationException()

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(2000)
            println("Will not be printed")
        }
        throw MyNonPropagatingException
    }

    launch {
        delay(2000)
        println("Will be printed")
    }
}