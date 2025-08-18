package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

fun main() {
    val name = CoroutineName("A name")
    val element : CoroutineContext.Element = name
    val context : CoroutineContext = element

    val job: Job = Job()
    val jobElement: CoroutineContext.Element = job
    val jobContext: CoroutineContext = jobElement

    val ctx: CoroutineContext = name + job
}