package coroutines_study.f_203_job

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job: Job = launch {
        delay(1000L)
    }

    val parentJob: Job = coroutineContext.job
    println(job == parentJob)
    val parentChildren: Sequence<Job> = parentJob.children
    println(parentChildren.first() == job)
}