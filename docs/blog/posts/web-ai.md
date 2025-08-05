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

All these APIs provide a high-level and similar interface, making it easy to switch between them.
The general flow for using these APIs is as follows:

1. Check if the API is supported in the browser with a `if ("APIName" in window)` check.
1. Check if the API the availability of the API and the model by testing the return value of `await APIName.availability();`, which can be one of the following:
    - `unavailable`: the API is not supported in the browser or the model is not available.
    - `available`: the API is supported and the model is available and ready to use.
    - `downloadable`: the API is supported but the model is not available and can be downloaded.
    - `downloading`: the API is supported but the model is currently being downloaded.
1. If the API is `available`, `downloadable` or `downloading`, we can create an object to interact with the API by using the result of `await APIName.create(options)`. We can optionally pass in the `options` a callback function to be notified of the download progress. This is particularly useful for large models that are not yet downloaded.
1. Then we can ask the obtained object to perform the desired operation by calling the appropriate method with the required parameters. Many APIs support a `stream` option to get the result as a stream of events, which is useful for large inputs or outputs.

Let's take a look at an example of using the Translator API to translate a text from English to French:

```javascript
// Check if the Translator API is available in the browser
if (!("Translator" in window)) {
    console.error("Translator API is not available.");
    return;
}
// Setup the options for the Translator API
const options = {
    sourceLanguage: "en",
    targetLanguage: "fr"
};
// Check the availability of the Translator API and the model. We could also pass in a callback function to be notified of the download progress.
const availability = await Translator.availability(options);
if (availability === "unavailable") {
    console.error("Translator API is not available or the model is not available.");
    return;
}
// Create a Translator object with the desired options
const translator = await Translator.create(options);
// Ask the Translator object to translate a text
const result = await translator.translate("Hello, world!");
console.log(result);
// The output should be: "Bonjour, Monde !"
```

There may be some differences between the APIs, but the flow is generally the same.
For more examples, you can check the official [documentation](https://developer.chrome.com/docs/ai/built-in) and [my demo website](https://yostane.github.io/web-ai/) alongs [its source code](https://github.com/yostane/web-ai).

The advantages of using the Built-in AI web API are:

- **No external dependencies**: You don't need to include any external libraries or frameworks, which reduces the size of your application and improves performance.
- **Native support**: The API is built into the browser, which means it can take advantage of the browser's capabilities and optimizations.
- **Consistent interface**: The APIs have a similar interface, making it easy to switch between them and use them interchangeably.
- **Download the model once**: The API allows you to download the model once and reuse across the application, which reduces the loading time and improves performance.

The limitations of the Built-in AI web API are:

- **Limited model support**: The API currently supports only a limited set of models, which may not cover all use cases.
- **Browser compatibility**: The API is only available in certain browsers, so you need to check for compatibility before using it.
- **Limited functionality**: The API may not provide all the features and capabilities of a full-fledged AI library, so you may need to use other libraries for more advanced use cases.
- **Performance**: While the API is designed to be efficient, it may not perform as well as server-side AI solutions for large-scale or complex tasks.

## Transformer.js vs native AI API

## Browser AI vs server-side AI

## Conclusion
