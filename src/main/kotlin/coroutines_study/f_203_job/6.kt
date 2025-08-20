package coroutines_study.f_203_job

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val name = CoroutineName("Some name")
    val job = Job()

    launch(name + job) {
        val childName = coroutineContext[CoroutineName]
        println(childName == name)
        val childJob = coroutineContext[Job]
        println(childJob == job)
        println(childJob == job.children.first())
    }
}