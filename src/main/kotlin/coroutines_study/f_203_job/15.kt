package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()

    launch(job) {
        delay(1000)
        println("Test1")
    }

    launch(job) {
        delay(2000)
        println("Test2")
    }

    job.complete()
    job.join()
}