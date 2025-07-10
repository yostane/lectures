---
draft: true 
date: 2025-02-20 
categories:
  - Kotlin
  - Scripting
authors:
  - yostane
---

# Scripting with Kotlin

Kotlin is a modern programming language that supports many targets and allows to develop many applications types. From Android applications to server-side applications, Kotlin is a versatile language. Even though it is a compiled language at its core, Kotlin supports scripting, which allows you to write small programs or scripts that can be executed directly with a similar developer experience (DX) as a any other scripting language.

In this article, we will explore three ways of scripting with Kotlin: using the `*.main.kts` file, using *kscript* and finally using JBang.

## Scripting with `*.main.kts`

The official way of writing Kotlin scripts is with a `*.main.kts` file, which is a special file that can be executed directly. This file can contain Kotlin code and can be run using the `kotlin` command. For example, you can create a `script.main.kts` file with the following content:

```kotlin
#!/usr/bin/env kotlin

println("Hello, Kotlin scripting!")
```

You can then run this script using the following command:

```sh
kotlin script.main.kts
```

This will execute the script and print "Hello, Kotlin scripting!" to the console. You can also make the script executable by running:

```sh
chmod +x script.main.kts
```

and then run it directly:

```sh
./script.main.kts
```

`*.main.kts` scripts provide some features which are IntelliJ IDE support (VScode support is still lacking), debugging, implicit `argv` (command line arguments) and dependencies `@file:DependsOn` and `@file:Repository`. One nice benefit available out of the box is caching support for fast execution. Below is an example of a script that uses an RSS parser dependency:

```kotlin

```

You can run this script with the following command:

```sh
kotlin rssreader.main.kts [feed URL]
# For example:
rssreader.main.kts "https://blog.worldline.tech/index.xml"
```

Outputs:

```text
Showing the last 10 posts from https://blog.worldline.tech/index.xml
- The Yoga of Image Generation – Part 3
- Insights from Onboarding young developers and Mentoring Experiences
- The Yoga of Image Generation – Part 2
- The Superpowers of JavaScript Proxies
- Devops on Google Cloud Platform: Automating your build delivery on GCP in nutshell
- Introduction to QEMU 386
- The Yoga of Image Generation – Part 1
- Proper key management in the cloud with a Cloud Secure Module
- The OAuth proxification guide for frontend developers with Microsoft EntraID
- Gemini, but the other one
```

## Scripting with kscript

## Scripting with JBang

## References

- [May 2020: The state of Kotlin Scripting](https://mbonnin.medium.com/may-2020-the-state-of-kotlin-scripting-99cb6cc57db1)
- [November 2024: The state of Kotlin Scripting](https://mbonnin.net/2024-11-21_state-of-kotlin-scripting/)
