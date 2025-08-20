package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

private val CoroutineContext.job: Job
    get() = get(Job) ?: error("Current context doesn't...")

fun main(): Unit = runBlocking {
    println(coroutineContext.job.isActive)
}