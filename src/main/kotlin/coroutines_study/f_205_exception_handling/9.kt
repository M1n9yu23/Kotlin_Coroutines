package coroutines_study.f_205_exception_handling

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Caught $throwable")
    }

    val scope = CoroutineScope(SupervisorJob() + handler)

    scope.launch {
        delay(1000)
        throw Error("Some error")
    }

    scope.launch {
        delay(2000)
        println("Will be printed")
    }

    delay(3000)
}