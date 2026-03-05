package org.example

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

suspend fun main(){
    coroutineScope {
        // Keep a reference to the first coroutine
        val coroutine = launch {
            println("Start of coroutine 1")
            delay(1.seconds)
            println("End of coroutine 1")
        }
        // Wait for the first coroutine to complete
        coroutine.join()
        // Second coroutine
        launch { println("I am another coroutine")  }
    }
    println("Coroutine scope completed")
}