package coroutines_study.f_203_job

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking(CoroutineName("main")) {
    val name = coroutineContext[CoroutineName]?.name
    println(name)
    launch {
        delay(1000L)
        val name = coroutineContext[CoroutineName]?.name
        println(name)
    }
}