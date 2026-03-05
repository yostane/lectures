package org.example

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

suspend fun main(){
    coroutineScope {
        // First coroutine
        launch { 
            println("Start of coroutine 1")
            delay(1.seconds)
            println("End of coroutine 1")
        }
        // Second coroutine
        launch { println("I am another coroutine")  }
    }
    println("Coroutine scope completed")
}