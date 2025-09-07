package coroutines_study.f_206_coroutine_scope

import coroutines_study.f_103_suspension.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//private data class Details(val name: String, val followers: Int)
//private data class Tweet(val text: String)
//
//private fun getFollowersNumber() : Int = throw Error("Service exception")
//
//private suspend fun getUserName(): String {
//    delay(500)
//    return "민규!!"
//}
//
//private suspend fun getTweets(): List<Tweet> = listOf(Tweet("Hello, world"))
//
//private suspend fun CoroutineScope.getUserDetails(): Details {
//    val userName = async { getUserName() }
//    val followersNumber = async { getFollowersNumber() }
//    return Details(userName.await(), followersNumber.await())
//}
//
//fun main() = runBlocking {
//    val details = try {
//        getUserDetails()
//    } catch (e: Error) {
//        null
//    }
//
//    val tweets = async { getTweets() }
//    println("User: $details")
//    println("Tweets: ${tweets.await()}")
//}