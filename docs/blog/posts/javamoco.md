---
draft: true 
date: 2025-02-20 
categories:
  - Java
  - Concurrency
  - Tips
authors:
  - yostane
---

# Modern concurrency on the JVM with Coroutines and Loom

It's long finished the time where the Java ecosystem only has threads and async callback hells.
Indeed, we have a lot of elegant options for writing concurrent code on the JVM.
That is what we'll explore in this article through Project Loom and Kotlin coroutines.

<!-- more -->

## Introduction

Modern concurrent programming bring two important features: soft threads and structured concurrency. These are language agnostic and may already be found in other programming languages.
Soft threads are lightweight threads that are managed by the runtime, as opposed to regular thread which are managed by the operating system. Structured concurrency is a way to write concurrent code that is organized and clear taking advantage of classic sequential programming constructs (loops, if, etc.), thus avoiding us dealing with async callbacks.

With regard to the JVM ecosystem, Kotlin implements these two features with coroutines since Kotlin 1.1 (which was release in 2011).
Java developers had to wait until Java 21 (which was release in 2021) to have a preview of structured concurrency with Project Loom.

With the release of Java 24, it's a good time to take a look at these two approaches.
Let's start by exploring Project Loom.

## Loom

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
