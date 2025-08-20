package coroutines_study.f_203_job

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {
    launch {
        delay(1000L)
        println("Test1")
    }

    launch {
        delay(2000L)
        println("Test2")
    }

    val children = coroutineContext[Job]?.children

    val childrenNum = children?.count()
    println("Number of children: $childrenNum")
    children?.forEach { it.join() }
    println("All tests are done")
}