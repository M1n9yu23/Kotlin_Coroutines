package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.CoroutineName
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx1: CoroutineContext = CoroutineName("Name1")
    println(ctx1[CoroutineName]?.name)

    val ctx2: CoroutineContext = CoroutineName("Name2")
    println(ctx2[CoroutineName]?.name)

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name)
}