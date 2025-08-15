package coroutines_study.`103_suspension`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// 이렇게 구현 하면 안됨!
private var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCoroutine<Unit> { cont ->
        continuation = cont
    }
}

suspend fun main() = coroutineScope {
    println("Before")

    launch {
        delay(1000)
        continuation?.resume(Unit)
    }

    suspendAndSetContinuation()
    println("After")
}