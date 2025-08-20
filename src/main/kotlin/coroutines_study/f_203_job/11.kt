package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Job 팩토리 함수 잘못된 사용

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        delay(1000L)
        println("Test1")
    }

    launch(job) {
        delay(2000L)
        println("Test2")
    }

    job.join()
    println("Will not be printed")
}