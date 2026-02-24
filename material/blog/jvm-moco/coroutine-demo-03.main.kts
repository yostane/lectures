#!/usr/bin/env kotlin

@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import java.util.concurrent.ConcurrentHashMap

suspend fun main(){
    val uniqueThreadNames = ConcurrentHashMap.newKeySet<Long>()
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(1.seconds)
                uniqueThreadNames.add(Thread.currentThread().threadId())
            }
        }
    }
    println("Unique threads used: ${uniqueThreadNames.size}")
}