package coroutines_study.`103_suspension`

import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun continueAfterSecond(continuation: Continuation<Unit>) {
    thread {
        Thread.sleep(1000)
        continuation.resume(Unit)
    }
}

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        continueAfterSecond(continuation)
    }

    println("After")
}