package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx1: CoroutineContext = CoroutineName("Name1")
    println(ctx1[CoroutineName]?.name)
    println(ctx1[Job]?.isActive)

    val ctx2: CoroutineContext = Job()
    println(ctx2[CoroutineName]?.name)
    println(ctx2[Job]?.isActive)

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name)
    println(ctx3[Job]?.isActive)
}