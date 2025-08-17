package coroutines_study.f_103_suspension

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun requestUser() : User {
    return suspendCoroutine { cont ->
        requestUser { user ->
            cont.resume(user)
        }
    }
}

suspend fun main() {
    println("Before")

    val user = requestUser()

    println(user)
    println("After")
}