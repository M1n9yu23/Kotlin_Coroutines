package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class CounterContext(
    private val name: String
) : CoroutineContext.Element {
    override val key: CoroutineContext.Key<*> = Key
    private var nextNumber = 0

    fun printNext() {
        println("$name: $nextNumber")
        nextNumber++
    }

    companion object Key: CoroutineContext.Key<CounterContext>
}

suspend fun printNext() {
    coroutineContext[CounterContext]?.printNext()
}

suspend fun main() : Unit =
    withContext(CounterContext("Outer")) {
        printNext()
        launch {
            printNext()
            launch {
                printNext()
            }
            launch(CounterContext("Inner")) {
                printNext()
                printNext()
                launch {
                    printNext()
                }
            }
        }
        printNext()
    }