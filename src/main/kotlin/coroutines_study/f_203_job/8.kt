package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Job()) {
        delay(1000L)
        println("Will not be printed")
    }
}