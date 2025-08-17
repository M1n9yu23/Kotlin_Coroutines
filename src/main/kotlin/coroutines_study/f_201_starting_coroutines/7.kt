package coroutines_study.f_201_starting_coroutines

import kotlinx.coroutines.*

fun main() {
    // 이렇게 X
    // async를 launch로 잘못 사용한 경우 (값을 생성할 필요 없는데 async를 사용한 경우를 말함)
    runBlocking {
        GlobalScope.async {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        delay(2000L)
    }
}