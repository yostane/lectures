#!/usr/bin/env kotlin

@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import java.util.concurrent.ConcurrentHashMap

val uniqueThreadNames = ConcurrentHashMap.newKeySet<Long>()
val scope = CoroutineScope(Dispatchers.Default)
for (i in 1..100000) {
    scope.launch {
        val threadId: Long = Thread.currentThread().id
        uniqueThreadNames.add(threadId)
        delay(0.5.seconds)
    }
}
runBlocking { delay(10) }
println("Unique threads used: ${uniqueThreadNames.size}")