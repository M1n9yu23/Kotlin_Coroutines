package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val empty: CoroutineContext = EmptyCoroutineContext
    println(empty[CoroutineName])
    println(empty[Job])

    val ctxName = empty + CoroutineName("Name1") + empty
    println(ctxName[CoroutineName])

}