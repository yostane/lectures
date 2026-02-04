#!/usr/bin/env kotlin

@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

suspend fun main(){
    coroutineScope {
        val coroutine = launch { 
            println("Start of coroutine 1")
            delay(1.seconds)
            println("End of coroutine 1")
        }
        coroutine.join()
        launch { println("I am another coroutine")  }
    }
    println("Coroutine scope completed")
}