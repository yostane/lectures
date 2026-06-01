---
draft: true 
date: 2025-01-20 
categories:
  - Java
  - Concurrency
  - Tips
authors:
  - yostane
---

# Modern concurrency approaches on the JVM: Coroutines and Loom

Concurrent programming allows to run multiple tasks simultaneously, and was achievable mostly through threads.
However, they are hard to code with and have some limitations.
Modern concurrent programming brings new concepts that make concurrent programming easier and more efficient.
Two of those concepts is structured concurrency and lightweight threads, which are implemented in the JVM ecosystem through Kotlin coroutines and Project Loom.
Let's explore these two approaches.

<!-- more -->

## Introduction

Traditional (thread based) concurrency has many issues, such as [callback hell](https://callbackhell.com/) and high consumption of system resources by extensive creation of threads.
Let's illustrate them in this example that creates 1000 threads that each sleep for 1 second and then print the number of unique ones.

```java
--8<--
blog/jvm-moco/scripts/ThousandThreads.java
--8<--
```

The output should be as follows, and shows that 1000 threads were created:

```txt
1
...
...
999
1000
```

By analyzing both the code and the output, we can note two above mentioned problems:

- The code is sensible to callback hell: since threads are created with a lambda, they require a callback style of programming if we want to perform actions after the thread completes, which can lead to deeply nested code that is hard to read, predict and maintain.
- The system resources are not optimized: creating 1000 threads can be resource intensive, especially if the tasks are I/O bound and spend much of their time waiting. This can lead to high memory consumption and context switching overhead. In addition to that, there is a limit to the number of threads that can be created by the OS. We can verify this by increasing the number of threads to 1 million, which will throw an `OutOfMemoryError` or `Too many threads` error depending on the OS.

```java
--8<--
blog/jvm-moco/scripts/MillionThreads.java
--8<--
```

Runnning the above code will throw an error similar to the following:

```txt
[0.536s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 2048k, guardsize: 16k, detached.
[0.536s][warning][os,thread] Failed to start the native thread for java.lang.Thread "Thread-4068"
Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
        at java.base/java.lang.Thread.start0(Native Method)
        at java.base/java.lang.Thread.start(Thread.java:1417)
        at MillionThreads.main(MillionThreads.java:9)
```

Modern concurrency concepts solve these issues as we'll see in the next sections.
Let's start by defining some concepts before delving into concrete implementations.

## Modern concurrency concepts

There are two main concepts in modern concurrency that we will explore in this post: lightweight threads and structured concurrency.

### Lightweight threads

They are threads that are managed by the runtime (like the JVM or Kotlin runtime) instead of the operating system.
They still run on top of OS threads, also called platform threads or carrier threads (because they carry the lightweight threads).
However, lightweight threads can reuse platform threads, which allows to bypass the limit of OS threads.
In addition to that, the usage of system resources is optimized, since platform threads are more expensive to create and maintain than lightweight ones.

Lightweight threads are very efficient for tasks that spend most of their time waiting, such as I/O-bound (network, file I/O, etc.).
This means that we can spawn a large number of lightweight threads that download files or communicate with printers without worrying about system resources, which is not the case with traditional threads.
It is important to note that compute-intensive tasks are still bound to the raw CPU and GPU cores and power. Thus, running a large number of compute-intensive tasks efficiently in parallel is not possible on low-end hardware, even with lightweight threads.

The JVM has two implementations of lightweight threads: coroutines (introduced by Kotlin) and virtual threads (introduced by Project Loom).

### Structured concurrency

Structured concurrency is a programming paradigm that aims to make concurrent code similar to a sequential one.
It is achieved by providing APIs that replace the traditional, callback-based, ones with constructs that enforce a sequential structure for concurrent tasks.
We can also see structured concurrency in JavaScript, C# and Swift with the `async`/`await` keywords.

In the JVM ecosystem, structured concurrency is implemented by Kotlin coroutines and Project Loom.

## Kotlin coroutines

A coroutine is a lightweight thread that is managed by the Kotlin runtime.
Kotlin implements coroutines since version 1.1, released in 2011.
Coroutines can be suspended and resumed, which allows to write asynchronous code in a sequential way.

Two concepts are essential to understand coroutines: **suspending functions** and **CoroutineScope**.
Coroutines run inside a **CoroutineScope**, which is a context that defines the lifecycle of the coroutines.
A **suspending function** is function that is marked with the `suspend` keyword.
Any function that calls suspending functions must be marked as `suspend` as well (similar to the `async` keyword in other languages).

Regarding the lightweight aspect of coroutines, we can illustrate this by creating thousands of coroutines without worrying about system resources.
Let's illustrate this with a program that creates 1 million coroutines that each sleep for 1 second and then prints the number of unique coroutines.

```kotlin
--8<--
blog/jvm-moco/coroutines/app/src/main/kotlin/org/example/CoroutineDemo03.kt
--8<--
```

The output depends on the number of cores on the CPU.
It should be something like this on macPro m1 with 8 cores:

```txt
Unique threads used: 8
```

This means that the coroutines are efficiently scheduled on the available hardware cores, without the overhead of creating a large number of OS threads.
In fact, we can even increase the number of coroutines to more than 1 million without any issue, which is not possible with traditional (OS) threads.

The second aspect of coroutines is structured concurrency, which allows to write concurrent code that looks like sequential code.
Let's see an example of how to create a coroutine scope that launches two coroutines.

```kotlin
--8<--
blog/jvm-moco/coroutines/app/src/main/kotlin/org/example/CoroutineDemo01.kt
--8<--
```

The coroutine scope is created with the `coroutineScope` suspending function (defined with the `suspend` qualifier).
Since it is a suspending function, then the `main` function that calls it must be marked as `suspend` as well.
That's why the `main` function is defined with `suspend fun main()`.
The coroutine scope launches two coroutines with the `launch` function (`launch` creates a coroutine and runs it).
The first one prints a message, sleeps for 1 second and then prints another message.
The second one simply prints a message.

Can you guess the output of this code? Here is the answer:

```txt
Start of coroutine 1
I am another coroutine
End of coroutine 1
Coroutine scope completed
```

Since the first coroutine sleeps for 1 second, the second coroutine is executed while the first one is suspended.
What if we want to start the second one only after the first one completes?
That can be achieved with the `join` function, which waits for the completion of a coroutine.

```kotlin
--8<--
blog/jvm-moco/coroutines/app/src/main/kotlin/org/example/CoroutineDemo02.kt
--8<--
```

The output of this code is:

```txt
Start of coroutine 1
End of coroutine 1
I am another coroutine
Coroutine scope completed
```

By getting a reference to the first coroutine with `val job1 = launch { ... }`, we call `job1.join()` to wait for its completion before starting the second one.

The above two examples show the essence of structured concurrency: the code looks like sequential code, but it is actually concurrent code.
No more callback hell, just sequential code!

Let's see next how the JDK implements modern concurrency.

## Java's virtual threads and structured concurrency

In addition to Kotlin Courourines, the JDK natively achieves modern concurrency through two APIs: virtual threads and structured concurrency.

Virtual threads are the JDK implementation of lightweight threads, and are introduced by Project Loom.
They share a similar API with platform threads since they both implement the Thread interface.
They can be spawned using the static method `Thread.ofVirtual()`.

The following code snippet illustrates the creation of a platform thread and a virtual thread.

```java
--8<--
blog/jvm-moco/scripts/virtual_thread.java
--8<--
```

The output of this code is similar to the following:

```txt
Thread[#25,Thread-0,5,main]
VirtualThread[#27]/runnable@ForkJoinPool-1-worker-1
```

In the above logs, we can confirm that the classical -platform- thread is created from the main thread, while the virtual thread is created by the [ForkJoinPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html).
The ForkJoinPool is a thread pool that is specialized in running tasks that can be broken down into smaller tasks.
This means that virtual threads are managed internally by the ForkJoinPool and not directly by the OS, which allows them to be lightweight and efficient.
As of the writing of this post, virtual threads are scheduled only on this kind of pool.

Thanks to their nature, and similarly to Kotlin coroutines, we can create a large number of virtual threads without worrying about system resources.
The following code snippet creates 1 million virtual threads and prints additional information about them.

```java
--8<--
blog/jvm-moco/scripts/MillionVirtualThreads.java
--8<--
```

Let's explain some parts.
The line `var threadInfo = Thread.currentThread().toString();`, generates a string that looks like this: `VirtualThread[#(id)]/runnable@ForkJoinPool-(id)-worker-(id)`.
The next lines extract from it the unique `ForJoinPool...` part which contain the id of the `ForkJoinPool` and the id its worker thread.
The worker thread is the platform thread that runs the virtual thread.
So, at the end of the execution, we can see how many unique `ForkJoinPool` instances have been created and how many worker thread have been associated to them.

The log output of the above code is similar to the following:

```txt
...
VirtualThread[#1000029]/runnable@ForkJoinPool-1-worker-4
VirtualThread[#1000031]/runnable@ForkJoinPool-1-worker-1
VirtualThread[#1000032]/runnable@ForkJoinPool-1-worker-7
VirtualThread[#1000034]/runnable@ForkJoinPool-1-worker-4
...
ForkJoinPool-1-worker-8
ForkJoinPool-1-worker-6
ForkJoinPool-1-worker-7
ForkJoinPool-1-worker-1
ForkJoinPool-1-worker-4
ForkJoinPool-1-worker-5
ForkJoinPool-1-worker-2
ForkJoinPool-1-worker-3
```

We can divide the log output into two parts.
The first part prints 1 million lines in this format VirtualThread[#(id)]/runnable@ForkJoinPool-(id)-worker-(id)`.
The second part follows the first one by eight lines with this format `ForkJoinPool-1-worker-(1 to 8)`.
The first part shows that all the virtual threads are scheduled on the same `ForkJoinPool` instance, which is expected since the default `ForkJoinPool` is used for scheduling virtual threads.
The second part, with only eight lines, shows that the virtual threads are scheduled on 8 unique worker threads, which is also the number of cores on the CPU of the machine where the code is executed.
This means that the virtual threads are efficiently scheduled on the available hardware cores, without the overhead of creating a large number of OS threads.

The other aspect of Java's modern concurrency is structured concurrency.
The class that provides this feature is [`StructuredTaskScope`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/StructuredTaskScope.html).
It is available in Java 21 as a preview feature (it is still the case in Java 25).
It returns an object, usually created with a try-with-resources block, that we'll call a **scope**.
That scope is be used to launch concurrent tasks with the `fork` method, and to wait for their completion with the `join` method.
Chaining the `join` method with the `fork` method allows to create a sequential structure for concurrent tasks, which is the essence of structured concurrency.
The following code snippet illustrates the use of structured concurrency to launch two tasks sequentially, and then launch a third one after their completion.

```java
--8<--
blog/jvm-moco/scripts/structured_concurrency.java
--8<--
```

Running the above code will produce an output similar to the following:

```txt
Task 1
Task 2
Sum: 3
Task 3 runs after task 1 and task 2
Sum: 6
```

We can see that the first two tasks are launched concurrently, and their results are printed after their completion.
Then, the third task is launched after the completion of the first two tasks, which shows the sequential structure of the concurrent code.
This, again, is the essence of structured concurrency: the code looks like sequential code, but it is actually concurrent code.

## Coroutines vs Java modern concurrency

While coroutines and Java's modern concurrency are two implementations of the same concepts - lightweight threads and structured concurrency -, they have some differences and synergies that are worth mentioning.

Coroutines are available in Kotlin since 2011, while Java's modern concurrency is available in Java 21, and thus also Kotlin, as a preview feature. 
This means that coroutines are more mature and adopted as of now.

Since virtual threads use the `Thread` API, they can be used in Java and Kotlin, while coroutines can only be used in Kotlin.
Also, Virtual threads can be used by frameworks behind the scenes, since it's sometimes just a matter of changing the thread factory.
This means that developers might not to be aware of them or change their code to use them, while coroutines require explicit usage of the API.

A synergy between the two APIs is possible when Kotlin runs on the JVM (i.e. with desktop and server app). In fact, coroutines can be dispatched on Java's virtual threads thanks to `Dispatchers.LOOM`, which schedules coroutines on virtual threads.
The opposite is not possible, meaning that Java's `StructuredTaskScope` cannot be used to launch coroutines, since it is not aware of them.

To conclude, we may wonder which one to choose. 
The short answer is: use the one that is available in your language and framework.
So, if you are using Java, then you can use Java's modern concurrency.
And, if you are using Kotlin, then you can use Kotlin coroutines.

## Conclusion

Programs that run on the JVM have two ways to run structured concurrent code that optimizes IO performance and readability.
On JDK side, we have virtual threads and structured concurrency with `StructuredTaskScope`.
In Kotlin, coroutines is a high level API that provides lightweight threads and structured concurrency.
Both APIs are efficient and easy to use, and can be used in synergy when running Kotlin on the JVM.

## Links and references

- [Structured concurrency explained - Part 1: Introduction](https://www.thedevtavern.com/blog/posts/structured-concurrency-explained/)
- [Project Loom: Understand the new Java concurrency model](https://www.infoworld.com/article/3652596/project-loom-understand-the-new-java-concurrency-model.html)
