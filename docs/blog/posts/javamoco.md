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

# Modern concurrency on the JVM with Coroutines and Loom

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
- The system resources are not optimized: creating 1000 threads can be resource intensive, especially if the tasks are I/O bound and spend much of their time waiting. This can lead to high memory consumption and context switching overhead. In addition to that, there is a limit to the number of threads that can be created by the OS.

Modern concurrency concepts solve these issues as we'll see in the next sections.
Let's start by defining these concepts before delving into concrete implementations.

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
In fact, we can even increase the number of coroutines to more than 1 million without any issue, which is not possible with traditional threads.

Let's see next how the JDK implements modern concurrency.

## Modern concurrency in the JDK

The JDK achieved modern concurrency through two APIs: virtual threads and structured concurrency.

Virtual threads are the JDK implementation of lightweight threads, and are introduced by Project Loom.
There are many ways to create virtual threads, but the most common one is with the `Thread` class, which has two static factory methods: `ofPlatform()` and `ofVirtual()`.

The following code snippets illustrates the creation of a platform thread and a virtual thread.

```java
blog/jvm-moco/scripts/virtual_thread.java
```

The output of this code is similar to the following:

```txt
Thread[#25,Thread-0,5,main]
VirtualThread[#27]/runnable@ForkJoinPool-1-worker-1
```

We can note that the platform thread is created from the main thread, while the virtual thread is created by the [ForkJoinPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html).
The ForkJoinPool is a special thread pool that can execute subtasks recursively

### Java's structured concurrency

The main class for achieve structured concurrency in Java is the [StructuredTaskScope](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/StructuredTaskScope.html).
It is available in Java 21 as a preview feature.

## Kotlin coroutines

Kotlin coroutines is high level cross-platform API for writing efficient concurrent code.
It enables to write asynchronous code in a sequential way as well as structured concurrency.
The former means that you can write asynchronous code that looks like synchronous code, eliminating the callback hall problem.
The latter means that you can write concurrent code that is easy to reason about and where the start and end of concurrent paths are clear and explicit ([ref](https://www.thedevtavern.com/blog/posts/structured-concurrency-explained/)).

## Writing concurrent code with Kotlin coroutines

## Coroutines vs loom

For Java developers, project Loom is the way to go.

For Kotlin developers, both technologies are complementary and can be used together to write efficient concurrent code on the JVM.
Corourines were available since Kotlin 1.1, while Project Loom is still in development, even though some APIs are stable.

## Conclusion

Developers for the JVM have now more options to write concurrent code.
Project Loom brings new concepts to the JVM that make it easier to write efficient concurrent code.
Kotlin coroutines is a high level API that enables to write asynchronous code in a sequential way as well as structured concurrency.

## Links and references

- [Structured concurrency explained - Part 1: Introduction](https://www.thedevtavern.com/blog/posts/structured-concurrency-explained/)
- [Project Loom: Understand the new Java concurrency model](https://www.infoworld.com/article/3652596/project-loom-understand-the-new-java-concurrency-model.html)
