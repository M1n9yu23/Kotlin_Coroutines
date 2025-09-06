package coroutines_study.f_205_exception_handling

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // 이렇게 하면 안됨. 자식 코루틴 하나가 있고
    // 부모 코루틴이 없는 잡은 일반 잡과 동일하게 작동함.
    launch(SupervisorJob()) {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Will not be printed")
        }
    }

    delay(3000)
}