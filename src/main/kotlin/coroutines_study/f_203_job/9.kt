package coroutines_study.f_203_job

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(1000L)
        println("Test1")
    }

    val job2 = launch {
        delay(1000L)
        println("Test2")
    }

    job1.join()
    job2.join()
    println("All tests are done")
}