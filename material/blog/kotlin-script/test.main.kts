#!/usr/bin/env kotlin

@file:DependsOn("com.prof18.rssparser:rssparser:6.1.0-alpha01")

import com.prof18.rssparser.RssParser
import com.prof18.rssparser.model.RssChannel

val feedUrl = args[1]

val rssParser = RssParser()
val rssChannel: RssChannel = rssParser.getRssChannel(feedUrl)