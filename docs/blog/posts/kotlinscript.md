---
date: 2025-07-11
categories:
  - Kotlin
  - Scripting
authors:
  - yostane
---

# Scripting with Kotlin

Kotlin is a modern programming language that supports many targets and allows to develop many applications types. From Android applications to server-side applications, Kotlin is a versatile language. Even though it is a compiled language at its core, Kotlin supports scripting, which allows you to write small programs or scripts that can be executed directly with a similar developer experience (DX) as a any other scripting language.

In this article, we will explore three ways of scripting with Kotlin: using the `*.main.kts` file, using *kscript* and finally using JBang. We'll also mention Kotlin notebooks as a bonus, so stick until the end!

<!-- more -->

## Scripting with `*.main.kts`

The official way of writing Kotlin scripts is with a `*.main.kts` file, which is a special file that can be executed directly. This file can contain Kotlin code and can be run using the `kotlin` command. For example, you can create a `script.main.kts` file with the following content:

```kotlin
#!/usr/bin/env kotlin

println("Hello, Kotlin scripting!")
```

The script can be executed using the following command:

```sh
kotlin script.main.kts
```

This will print "Hello, Kotlin scripting!" to the console. We can also make the script executable by running:

```sh
chmod +x script.main.kts
```

and then run it directly:

```sh
./script.main.kts
```

`*.main.kts` scripts provide useful features such as debugging, implicit `argv` (command line arguments) and dependencies `@file:DependsOn` and `@file:Repository`.
One nice benefit available out of the box is caching support for fast execution.

Below is an example of a script that prints the last 10 posts from a given RSS feed URL.
It showcases how to use the `@file:DependsOn` annotation to include dependencies, and how to use the `argv` variable to get command line arguments.

```kotlin
--8<--
blog/kotlin-script/rssreader.main.kts
--8<--
```

The script can be executed with the following command:

```sh
kotlin rssreader.main.kts [feed URL]
# For example:
rssreader.main.kts "https://blog.worldline.tech/index.xml"
```

The output of the script will be similar to the following:

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

Kotlin scripting with `*.main.kts` file is a straightforward way to write and execute Kotlin scripts.
It is available out of the box with the Kotlin compiler.
However, I found the DX still not ideal for three reasons.
First, the `*.main.kts` file is currently only supported by IntelliJ IDEA (and I had to restart the IDE to get the dependency recognized).
Second, I was not able to run the scripts with the `./script.main.kts` command because of this error `env: kotlin\r: No such file or directory`, which prevented scripts from running.
I had to resort to using the `kotlin script.main.kts` command instead.
Lastly, the status of this feature is still experimental, meaning that things may change in the future.
To prove that, JetBrains has written a blog post about [the current state of Kotlin scripting by the end of 2024](https://blog.jetbrains.com/kotlin/2024/11/state-of-kotlin-scripting-2024/) which initially some provoked some doubts misunderstanding about the future of official Kotlin scripting support.
In the end, it was just a feedback about other less successful and relevant scripting features being dropped.
To read more about the current state of official Kotlin scripting, pelase read [InfoWorld](https://www.infoworld.com/article/3613358/kotlin-to-lose-scripting-features.html), and [Martin Bonin](https://mbonnin.net/2024-11-21_state-of-kotlin-scripting/) posts about the current state of Kotlin scripting.

In addition to the official `*.main.kts` scripting, there are two other popular ways to write Kotlin scripts: using *kscript* and *JBang*.

## Scripting with kscript

kscript is an open-source tool that aims to write Kotlin scripts with a more user-friendly experience.
It provides a command-line interface and a set of features that make it easier to write and run Kotlin scripts.

After installing [kscript](https://github.com/kscripting/kscript?tab=readme-ov-file#installation), we can create a script file with the `.kts` extension and add the shebang line at the top of the file.
For example, the following file, named `script.kts`, is a kscript file that prints "Hello, Kotlin scripting!" and takes a command line argument:

```kotlin
#!/usr/bin/env kscript

println("Hello, Kotlin scripting! ${args[0]}")
```

Similarly to the `*.main.kts` scripting, we can run the script using the `kscript` command:

```sh
kscript script.kts "from kscript"
```

We can also make the script executable by running:

```sh
chmod +x script.kts
```

And then run it directly:

```sh
./script.kts "from kscript"
```

kscript shares similar features with the official `*.main.kts` scripting, such as dependency management and command line arguments.
It also provides some more developer-friendly features such as passing code from the command line.
The following commands showcases two examples of passing code from the command line to kscript:

```sh
kscript 'println("hello world")'
echo 'println("Hello Kotlin.")' |  kscript -
```

kscript was really useful in the past, when the official Kotlin scripting support was still in its infancy.
However, it is not the case anymore because many exclusive features of kscript have been integrated into the official `*.main.kts` scripting, such as dependency management, command line arguments, and more.
In addition to that, kscript has not been updated for a long time and the last release was in July 2023.

For a better third-party Kotlin scripting experience, I recommend using JBang as we'll see next.

## Scripting with JBang

JBang can be defined as a multipurpose tool centered around using self-contained files for JVM languages (Java, Kotlin, etc.).
In fact, in addition to scripting, we can generate jars, run them and share our scripts in a neat way.
For more details on JBang features aside scripting, please refer to my [blog post about JBang](https://blog.worldline.tech/2025/01/21/jbang.html), [my last talk at Devoxx UK](https://www.youtube.com/watch?v=3QnwTmHGct8), and [the official website](https://www.jbang.dev/).
In this section, we will focus on the scripting features of JBang.

The following commands showcase how to use JBang to create and run a Kotlin script:

```sh
jbang init -t hello.kt hello-jbang.kt
# Execute the file
jbang hello-jbang.kt
# or like this
chmod +x hello-jbang.kt
./hello-jbang.kt
```

The `hello-jbang.kt` file is a regular Kotlin file with a main method. What makes it a script is the JBang annotation at the top of the file, also called a shebang, which tells JBang to execute the file as a script.
The content of the file is as follows:

```kotlin
--8<--
blog/kotlin-script/hello-jbang.kt
--8<--
```

JBang supports all scripting features of `*.main.kts` with these additions:

- *File extension is .kt*: keeping the same extension as our usual Kotlin files. Thus, the file must have a main method.
- *Templates*: the ability to create scripts from predefined models.
- *Include other sources*: very useful if you want to share code between scripts.
- *Include resources*: if your code has resources, such as an app icon, or a translation file.
- *Compiler and runtime options*: For customizing the behavior of the compiler and the runtime.

The following script illustrates a Quarkus Rest server written in Kotlin using JBang.
It uses the `//DEPS` feature to include dependencies.

```kotlin
///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS io.ktor:ktor-bom:3.0.1@pom
//DEPS io.ktor:ktor-server-netty-jvm
//DEPS io.ktor:ktor-serialization-jackson-jvm
//DEPS io.ktor:ktor-server-content-negotiation-jvm

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

data class Todo(val title: String, val isCompleted: Boolean)

fun main(args: Array<String>) {
    val todos = listOf(Todo("Sleep", false), Todo("Eat", true))
    print(todos)
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }
        routing { get("/") { call.respond(todos) } }
    }.start(wait = true)
}
```

We can run it with the following command that downloads the scripts and runs it locally:

```sh
jbang ktor-rest@yostane
```

In my opinion, JBang is currently the best way for writing Kotlin scripts because of its versatility and extensive features.

The next section covers an alternative way of running Kotlin code blocks, which is not exactly scripting but is worth mentioning.

## Bonus: Kotlin notebooks

Jupyter notebook is a standard format for writing markdown, code and the result of the code, all in a single file.
The extension of these files is `ipython` (interactive python notebooks)
Notebooks really powerful and attractive for these reasons in my opinion:

- The language of code blocks can be in any language, as long as a Jupyter Kernel for that language is installed.
- Code blocks can be executed in any order and independently and there is a global session context that remembers the values of global variables across code blocks' executions. Even though there is Python in the extension name, it does indicate nowadays that it supports only Python.
- Code and markdown blocks can be written in any order
- GitHub, GitLab and many other tools and apps render Jupyter Notebooks properly, including syntax highlighting and graphics and charts generated by code.

All these features make Jupyter Notebooks great for writing documentation, expeimenting, datascience and for scripting.

Kotlin has official scritinh support thrhough the availability of a Kotlin Kernel, that allow to run Kotlin code blocks, and IntelliJ and VSCode extensions for Kotlin notebooks, that enable the editing freatures that we find in regular Kotlon files (syntex highlightinh, code suggestions, etc.).

The following screenshot illustrates a Kotlin notebook with a markdown block, a code block and the result of the code block.

![Kotlin notebook sample](./img/kotlin-notebook.png)

The notebook can be opened and edited with IntelliJ IDEA, VSCode or any other Jupyter Notebook compatible editor.
It can also be rendered on GitHub or GitLab. The above notebook can be visualized on [GitHub by following this link](https://github.com/worldline/learning-kotlin/blob/main/material/conferences/2025-03-26-voxxed-bucharest/01-language.ipynb).

Here are some other screenshots of Kotlin notebooks:

![Kandy graph](./img/kandy-graph.png)

![source: https://github.com/gaplo917/awesome-kotlin-notebook/blob/main/postgres/postgres-vanilla.ipynb](./img/sql-notebook.png)
([source gaplo917/awesome-kotlin-notebook](https://github.com/gaplo917/awesome-kotlin-notebook/blob/main/postgres/postgres-vanilla.ipynb))

Kotlin notebooks are a great way to write Kotlin code in a more interactive and visual way.
They are not exactly scripting, but they can be used for scripting-like tasks, such as experimenting with code, writing documentation, and sharing code snippets.

## Conclusion

Kotlin is a powerful and versatile language.
Among its possibilities, we have explored in this post three ways to write scripts with Kotlin: using the official `*.main.kts` scripting, using kscript, and using JBang.
Personally, I prefer to use JBang but if you want to stick to the official approach, then `*.main.kts` is the way. In any case, kscript is to be avoided for its lack of features and updates.

## References

- [May 2020: The state of Kotlin Scripting](https://mbonnin.medium.com/may-2020-the-state-of-kotlin-scripting-99cb6cc57db1)
- [November 2024: The state of Kotlin Scripting](https://mbonnin.net/2024-11-21_state-of-kotlin-scripting/)
