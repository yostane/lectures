---
draft: true 
date: 2025-07-05 
categories:
  - Kotlin
  - Scripting
authors:
  - yostane
---

# Scripting with Kotlin

Kotlin is a modern programming language that supports many targets and allows to develop many applications types. From Android applications to server-side applications, Kotlin is a versatile language. Even though it is a compiled language at its core, Kotlin supports scripting, which allows you to write small programs or scripts that can be executed directly with a similar developer experience (DX) as a any other scripting language.

In this article, we will explore three ways of scripting with Kotlin: using the `*.main.kts` file, using *kscript* and finally using JBang.

<!-- more -->

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

`*.main.kts` scripts provide some features such as debugging, implicit `argv` (command line arguments) and dependencies `@file:DependsOn` and `@file:Repository`. One nice benefit available out of the box is caching support for fast execution.

Below is an example of a script that prints the last 10 posts from a given RSS feed URL. It showcases how to use the `@file:DependsOn` annotation to include dependencies, and how to use the `argv` variable to get command line arguments.

```kotlin
--8<--
blog/kotlin-script/rssreader.main.kts
--8<--
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

Kotlin scripts created with `*.main.kts` is a straightforward way to write and execute Kotlin scripts. It is available out of the box with the Kotlin compiler. However, I found the DX still not ideal for three reasons.
First, the `*.main.kts` file is currently only supported by IntelliJ IDEA (and I had to restart the IDE to get the dependency recognized).
Second, I was not able to run the scripts with the `./script.main.kts` command because of an `env: kotlin\r: No such file or directory` error which prevents the scripts from running this way. I had to resort to using the `kotlin script.main.kts` command instead.
Lastly, the status of this feature is still experimental, meaning that things may change in the future. To prove that, JetBrains has written a blog post about [the current state of Kotlin scripting by the end of 2024](https://blog.jetbrains.com/kotlin/2024/11/state-of-kotlin-scripting-2024/) which initially some provoked some doubts misunderstanding about the future of official Kotlin scripting support. In the end, it was just a feedback about other less successful and relevant scripting features being dropped. To read more about the current state of official Kotlin scripting, pelase read [InfoWorld](https://www.infoworld.com/article/3613358/kotlin-to-lose-scripting-features.html), and [Martin Bonin](https://mbonnin.net/2024-11-21_state-of-kotlin-scripting/) posts about the current state of Kotlin scripting.

In addition to the official `*.main.kts` scripting, there are two other popular ways to write Kotlin scripts: using *kscript* and *JBang*.

## Scripting with kscript

kscript is an open-source tool that aims to write Kotlin scripts with a more user-friendly experience. It provides a command-line interface and a set of features that make it easier to write and run Kotlin scripts.

After installing kscript, you can create a script file with the `.kts` extension and add the shebang line at the top of the file. For example, you can create a `script.kts` file with the following content:

```kotlin
#!/usr/bin/env kscript

println("Hello, Kotlin scripting! ${args[0]}")
```

and run it with the following command:

```sh
kscript script.kts "from kscript"
```

similar to the `*.main.kts` scripting, you can also make the script executable by running:

```sh
chmod +x script.kts
```

and then run it directly:

```sh
./script.kts "from kscript"
```

kscript share similar features with the official `*.main.kts` scripting, such as dependency management, command line arguments, and more. It also provides some more developer-friendly features such as passing code from the command line.

```sh
kscript 'println("hello world")'
echo 'println("Hello Kotlin.")' |  kscript -
```

kscript was really useful in the past, when the official Kotlin scripting support was still in its infancy. However, it is not the case anymore because many exclusive features of kscript have been integrated into the official `*.main.kts` scripting, such as dependency management, command line arguments, and more. In addition to that, kscript has not been updated for a long time and The last release was in July 2023.

For a better third-party Kotlin scripting experience, I recommend using JBang as we'll see next.

## Scripting with JBang

## References

- [May 2020: The state of Kotlin Scripting](https://mbonnin.medium.com/may-2020-the-state-of-kotlin-scripting-99cb6cc57db1)
- [November 2024: The state of Kotlin Scripting](https://mbonnin.net/2024-11-21_state-of-kotlin-scripting/)
