package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = Job()

    launch(job) {
        repeat(5) { num ->
            delay(200L)
            println("Rep$num")
        }
    }

    launch {
        delay(500)
        job.complete()
    }

    job.join()

    launch(job) {
        println("Will not be printed")
    }

    println("Done")
}