package coroutines_study.f_201_starting_coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val resultDeferred: Deferred<Int> = GlobalScope.async {
        delay(1000L)
        42
    }
    println(resultDeferred.await())
}