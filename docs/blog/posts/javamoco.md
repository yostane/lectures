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
blog/jvm-moco/thousand-threads.java
--8<--
```

We can note from the output that the 1000 threads are created.

```txt
1
...
...
999
1000
```

By analyzing the code and the output, we can note two above mentioned problems:

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
In addition to that, the usage of system resources is optimized, since platform threads are more expensive to create and maintain that lightweight threads.

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

```java
--8<--
blog/jvm-moco/coroutine-demo-01.main.kts
--8<--
```

The coroutine scope is created with the `coroutineScope` function.
Since the the `coroutineScope` is a suspending function (defined with the `suspend` qualifier), then the `main` function that calls it must be marked as `suspend` as well.
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

```java
--8<--
blog/jvm-moco/coroutine-demo-02.main.kts
--8<--
```

The output of this code is:

```txt
Start of coroutine 1
End of coroutine 1
I am another coroutine
Coroutine scope completed
```

By getting a reference to the first coroutine with `val job1 = launch { ... }`, we can call `job1.join()` to wait for its completion before starting the second coroutine.
That's where we can see the essence of structured concurrency: the code looks like sequential code, but it is actually concurrent code.
No more callback hell, just sequential code!

Regarding the lightweight aspect of coroutines, we can illustrate this by creating thousands of coroutines without worrying about system resources.
Let's see an example that creates 100000 coroutines that each delay for 1 second and then print the number of unique coroutines.

```java
```

## Java structured concurrency


Java developers had to wait until Java 21 (which was release in 2021) to have a preview of structured concurrency with Project Loom.

With the release of Java 24, it's a good time to take a look at these two approaches.
Let's start by exploring Project Loom.


Project Loom is an OpenJDK project that aims to bring modern concurrent programming to the JVM.
Loom introduces new concepts: virtual threads ([JEP 444](https://openjdk.org/jeps/444) previously called Fibers), which is an implementation of soft threads, and structured concurrency ([JEP 428](https://openjdk.org/jeps/425)).

### Virtual threads

Virtual threads are soft or lightweight threads that are managed by the JVM.
They use less memory than platform threads (the ones provided by the OS) and are more efficient for tasks that spend much of their time waiting.
This means that virtual threads are more efficient for I/O-bound tasks such as network or file I/O and less efficient for compute intensive tasks, like computing the n-th prime number. In that case, platform threads must be used.

It is possible to have many more virtual threads than platform threads which are capped due to OS and hardware limitations.

A virtual thread needs to run over at least one platform thread, also named a carrier thread in that case. A carrier thread can also host one or multiple virtual threads.

The following code snippets creates a virtual thread, with `Thread.ofPlatform()`, a platform thread, with `Thread.ofVirtual()` and each prints its information:

```java
// Platform (or OS) thread
Thread.ofPlatform().start(() -> {
    System.out.println(Thread.currentThread());
});

// Virtual thread
Thread.ofVirtual().start(() -> {
    System.out.println(Thread.currentThread());
});

/* Output:
Thread[#19,Thread-0,5,main]
VirtualThread[#20]/runnable@ForkJoinPool-1-worker-1
*/
```

We can note that the platform thread is created from the main thread, while the virtual thread is created by the [ForkJoinPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html). The ForkJoinPool is a special thread pool that is used to execute small tasks in parallel.

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
