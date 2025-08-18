package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job

fun main() {
    val ctx = CoroutineName("Name1") + Job()
    println(ctx[CoroutineName]?.name)
    println(ctx[Job]?.isActive)

    val ctx2 = ctx.minusKey(CoroutineName)
    println(ctx2[CoroutineName]?.name)
    println(ctx2[Job]?.isActive)

    val ctx3 = (ctx + CoroutineName("Name2")).minusKey(CoroutineName)
    println(ctx3[CoroutineName]?.name)
    println(ctx3[Job]?.isActive)
}