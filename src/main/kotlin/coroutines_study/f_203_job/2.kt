package coroutines_study.f_203_job

import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    val job = Job()
    println(job)
    job.complete()
    println(job)

    val activeJob = launch {
        delay(1000)
    }
    println(activeJob)
    activeJob.join()
    println(activeJob)

    val lazyJob = launch(start = CoroutineStart.LAZY) {
        delay(1000)
    }
    println(lazyJob)
    lazyJob.start()
    println(lazyJob)
    lazyJob.join()
    println(lazyJob)
}