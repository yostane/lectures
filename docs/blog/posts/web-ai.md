---
date: 2025-07-29
categories:
  - web
  - AI
authors:
  - yostane
draft: true
---

# No server needed: running AI in the browser

Running AI models is often associated with heavy server-side computations but it not true anymore. With advancements in hardware capabilities and the smart usage of small AI models, it is now possible to run AI models directly in the browser. This is a game changer as it brings new possibilities for building amazing user experiences and it makes AI more accessible to developers and users alike.

<!-- more -->

In this post, we will explore two ways to run AI model in the browser: transformer.js and the new Build-in AI web API. We will showcase some demos and discuss the benefits and limitations of each approach. By reading this article you will have a better understanding of how to run AI models in the browser and when to use it over server-side AI.

## transformer.js

Transformer.js is a JavaScript library that allows you to run transformer-based AI models directly in the browser. It leverages WebAssembly and WebGL to provide efficient computation, making it possible to run models like BERT, GPT, and others without needing a server.

Transformer.js is designed to be lightweight and easy to use, allowing developers to integrate AI capabilities into their web applications with minimal effort. It supports a variety of models and provides a simple API for loading and running them.

## Running AI natively in the browser

The new Built-in AI web API allows developers to run AI models natively in the browser without the need for any external libraries.
This API provides a simple and consistent interface for working with AI models, making it easy to integrate AI capabilities into web applications.

There are currently 7 APIS available in the Built-in AI web API, from which the first 6 can already be experimented in Chrome:

- [Translator API](https://developer.chrome.com/docs/ai/translator-api/)
- [Language Detection API](https://developer.chrome.com/docs/ai/language-detection)
- [Writer API](https://developer.chrome.com/docs/ai/writer-api)
- [Rewriter API](https://developer.chrome.com/docs/ai/rewriter-api)
- [Summarizer API](https://developer.chrome.com/docs/ai/summarizer-api/)
- [Prompt API](https://developer.chrome.com/docs/ai/prompt-api/)
- [Proofreader API](https://developer.chrome.com/docs/ai/proofreader-api/) (not yet available)

## Transformer.js vs native AI API

## Browser AI vs server-side AI

## Conclusion
