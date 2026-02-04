///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2"

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import java.util.concurrent.ConcurrentHashMap

suspend fun main(){
    val uniqueThreadNames = ConcurrentHashMap.newKeySet<String>()
    coroutineScope {
            for (i in 1..1000) {
                launch {
                    println(Thread.currentThread().name)
                    delay(1.seconds)
                    uniqueThreadNames.add(Thread.currentThread().name)
                }
            }
        }       
    }
    println("Unique threads used: ${uniqueThreadNames.size}")
}