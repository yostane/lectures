#!/usr/bin/env kotlin

@file:DependsOn("com.apptasticsoftware:rssreader:3.9.3")

import com.apptasticsoftware.rssreader.RssReader
import kotlin.jvm.optionals.getOrDefault

val feedUrl = args[0]
println("Showing the last 10 posts from $feedUrl")

var rssReader = RssReader()
var items = rssReader.read(feedUrl).filter { it.title.isPresent }
  .map { it.title.getOrDefault("") }.toList().take(10)
println(items.joinToString(separator = "\n- ", prefix = "- "))