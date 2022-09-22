package week7
import kotlinx.coroutines.*


fun threadName(): String = Thread.currentThread().name

fun main() {
    runBlocking {
        launch {
            test1WithCoroutines()
        }

        launch {
            test2WithCoroutines()
        }
    }
}

suspend fun test1WithCoroutines() {
    println("Start coroutines test 1: ${threadName()}")
    delay(500)
    println("End coroutines test 1: ${threadName()}")
}

suspend fun test2WithCoroutines() {
    println("Start coroutines test 2: ${threadName()}")
    delay(1000)
    println("End coroutines test 2: ${threadName()}")
}