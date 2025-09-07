package coroutines_study.f_206_coroutine_scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield


private data class User(val name: String)

private suspend fun fetchUser(): User {
    while(true) {
        yield()
    }
}

private suspend fun getUserOrNull(): User? = withTimeoutOrNull(5000) {
    fetchUser()
}

suspend fun main(): Unit = coroutineScope {
    val user = getUserOrNull()
    println("User: $user")
}