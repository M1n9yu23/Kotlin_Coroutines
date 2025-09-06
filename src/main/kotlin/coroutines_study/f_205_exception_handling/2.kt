package coroutines_study.f_205_exception_handling

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // try-catch 로 래핑하지 말기. 어차피 무시됨
    try {
        launch {
            delay(1000)
            throw Error("Some error")
        }
    } catch (e: Throwable) {
        println("Will not be printed")
    }
    launch {
        delay(2000)
        println("Will not be printed")
    }
}