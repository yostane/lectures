import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

val scope = CoroutineScope(Dispatchers.Default)

scope.launch {
    launch {
        println("Start of coroutine 1")
        delay(1.seconds)
        println("End of coroutine 1")
    }
    launch { println("I am another coroutine")  }
}
runBlocking { delay(5.seconds) }
println("Coroutine scope completed")