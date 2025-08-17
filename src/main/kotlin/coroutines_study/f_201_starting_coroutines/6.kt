package coroutines_study.f_201_starting_coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val res1 = GlobalScope.async {
        delay(1000L)
        "Text 1"
    }

    val res2 = GlobalScope.async {
        delay(1000L)
        "Text 2"
    }

    val res3 = GlobalScope.async {
        delay(1000L)
        "Text 3"
    }
    println(res1.await())
    println(res2.await())
    println(res3.await())
}