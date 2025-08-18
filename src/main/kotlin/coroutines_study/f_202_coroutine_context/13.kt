package coroutines_study.f_202_coroutine_context

import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

private data class User(val id: String, val name: String)

private abstract class UuidProviderContext : CoroutineContext.Element {
    abstract fun nextUuid(): String

    override val key: CoroutineContext.Key<*> = Key

    companion object Key : CoroutineContext.Key<UuidProviderContext>
}

private class RealUuidProviderContext : UuidProviderContext() {
    override fun nextUuid(): String {
        return UUID.randomUUID().toString()
    }
}

private class FakeUuidProviderContext(
    private val fakeUuid: String,
) : UuidProviderContext() {
    override fun nextUuid(): String {
        return fakeUuid
    }
}

private suspend fun nextUuid(): String = checkNotNull(coroutineContext[UuidProviderContext]) {
    "UuidProviderContext not present"
}.nextUuid()

// 테스트 하려는 함수
private suspend fun makeUser(name: String) = User(
    id = nextUuid(),
    name = name
)

suspend fun main(): Unit {
    // 프로덕션 환경
    withContext(RealUuidProviderContext()) {
        println(makeUser("Mingyu"))
    }

    // 테스트 환경
    withContext(FakeUuidProviderContext("FAKE_UUID")) {
        val user = makeUser("Mingyu")
        println(user)
        assert(User("FAKE_UUID", "Mingyu") == user)
        //assertEquals(User("FAKE_UUID", "Mingyu"), user)
    }
}