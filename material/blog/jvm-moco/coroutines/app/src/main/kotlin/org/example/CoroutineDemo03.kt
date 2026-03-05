package org.example

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import java.util.concurrent.ConcurrentHashMap

suspend fun main(){
    // Thread safe set
    val uniqueThreadNames = ConcurrentHashMap.newKeySet<Long>()
    coroutineScope {
        for (i in 1..1_000_000) {
            launch {
                delay(1.seconds)
                uniqueThreadNames.add(Thread.currentThread().threadId())
            }
        }
    }
    println("Unique threads used: ${uniqueThreadNames.size}")
}