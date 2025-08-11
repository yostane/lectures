---
date: 2025-07-29
categories:
  - web
  - AI
authors:
  - yostane
---

# No server needed: running AI in the browser

Running AI models is often associated with heavy server-side computations but it is not true anymore.

With advancements in hardware capabilities and the efficient use of small AI models, it is now possible to run AI models directly in the browser.
This is a game changer, bringing new possibilities for building amazing user experiences and making AI more accessible to both developers and users.

<!-- more -->

In this post, we will explore two ways to run AI model in the browser: transformer.js and the new Built-in AI web API.

We will showcase some demos and discuss the benefits and limitations of each approach.
By reading this article, you will gain a better understanding of how to run AI models in the browser and when to choose this approach over server-side AI.

## Transformer.js

Transformer.js is a JavaScript library from Hugging Face allowing to run pre-trained AI models directly in the browser or in a JS runtime (Node.js, bun, Deno, etc.).

It supports a wide range of models and use cases, including natural language processing (NLP), computer vision, audio, and more.

The general pattern of using transformer.js is as follows:

1. Add the library using a CDN or with `npm install @huggingface/transformers.js`.
2. Load the pipeline, providing the desired task and model, as well as other options.
    The most important parameter is the first one, which corresponds to the task you want to perform (e.g., "sentiment-analysis", "text-generation", etc.).
    The others are optional.
3. Call the loaded pipeline with the input data.
4. Process the output as needed.

To have a better understanding of how it works, let's create a sentiment analysis application using default model and options.

Let's create a vanilla web app with Vite that uses TypeScript and Bun.

    ```sh
    bun create vite@latest transformerjs-demo
    cd transformerjs-demo
    ```

1. Add the dependency for transformer.js:

    ```sh
    bun install @huggingface/transformers.js
    ```

1. In **index.html**, add some HTML code that asks the user to enter a sentence and provides a button to run the analysis:

    ```html
    <input type="text" id="input" placeholder="Enter a sentence" />
    <button id="analyze">Analyze</button>
    <div id="output"></div>
    ```

1. In **main.ts**, add an event handler for the button that sets up the transformer.js pipeline for the `sentiment-analysis` task and runs it:

    ```ts
    import { pipeline } from '@huggingface/transformers.js';

    const input = document.getElementById('input') as HTMLInputElement;
    const output = document.getElementById('output') as HTMLDivElement;

    document.getElementById('analyze')?.addEventListener('click', async () => {
        const model = await pipeline('sentiment-analysis');
        const result = await model(input.value) as any;
        output.innerHTML = result[0].label;
    });
    ```

Please find some example results in the following screenshots:

In the above code, when calling `await pipeline('sentiment-analysis')`, transformer.js will create a pipeline instance tailored for sentiment analysis.

It also automatically uses a default model as the second parameter, downloads it from Hugging Face's model hub, and loads it into the browser.
The third parameter of this function is the options object, with many available options.
To summarize, the arguments of `pipeline` are:

- `task`: The name of the task to perform (e.g., `"sentiment-analysis"`).
    The full list of supported tasks is available in the [official documentation](https://huggingface.co/docs/transformers.js/index#supported-tasksmodels) as tables grouped by task type.
    The `ID` column contains the unique identifier of the task and contains the possible values of the `task` parameter.
- `model`: The model to use for the task (optional).
    The full list of supported models is available in the [official documentation](https://huggingface.co/docs/transformers.js/index#models).
    However, it is recommended to open the `models` link in the tasks table to see the models available for each task.
- `options`: An object containing options for the pipeline (optional).
    Let's take a look at some of them:
        - `device`: Specifies if the model should run on the CPU or GPU. The library uses WebAssembly (WASM) by default and it is possible to set it to `webgpu` to provide more efficient computation.
        - `progress_callback`: provides progress updates.
        This is useful to report the progress to the user when a model is downloaded for the first time.

Let's use this new information to add a text to speech feature to our existing app.

1. Add a button for running text-to-speech:

    ```html
    <button id="speak">Speak</button>
    ```

2. Add an event handler that creates an `text-to-speech` to generate the raw audio, and then use `AudioContext` to play it back.

    ```js
    document.getElementById('speak')?.addEventListener('click', async () => {
        const synthesizer = await pipeline("text-to-speech", "Xenova/speecht5_tts");
        const embeddingUrl = "https://huggingface.co/datasets/Xenova/transformers.js-docs/resolve/main/speaker_embeddings.bin";
        const output = await synthesizer(text, {
            speaker_embeddings: embeddingUrl,
        });
        // Play the generated audio
        const audioContext = new AudioContext();
        const source = audioContext.createBufferSource();
        const audioBuffer = audioContext.createBuffer(1, output.audio.length, output.sampling_rate);
        audioBuffer.copyToChannel(output.audio as Float32Array<ArrayBuffer>, 0);
        source.buffer = audioBuffer;
        source.connect(audioContext.destination);
        source.start();
    });
    ```

Transformers.js supports many more use cases and can theoretically cover all the ones covered by [Transformers Python](https://github.com/huggingface/transformers).

Transformers.js supports many more use cases and can theoretically cover all those supported by [Transformers Python](https://github.com/huggingface/transformers).
However, while Transformers.js is designed to be functionally equivalent to its Python counterpart, it is important to note that it is not a direct port.
One difference is that the JS library uses the [ONNX runtime](https://onnxruntime.ai/) to run models in the browser and is thus compatible only with ONNX models.
Fortunately, it is possible to convert models from other frameworks like TensorFlow or PyTorch to ONNX format using a tool called [Optimum](https://github.com/huggingface/optimum#onnx--onnx-runtime).

This is just scratching the surface of what you can do with transformer.js.

## The built-in AI web APIs

The new Built-in AI web API allows developers to run AI models natively in the browser without the need for any external libraries.

This API provides a simple and consistent interface for working with AI models, making it easy to integrate AI capabilities into web applications.

There are currently 7 APIS available in the Built-in AI web API, from which the first 6 can already be experimented in Chrome:

There are currently 7 APIs available in the Built-in AI web API, of which the first 6 can already be experimented with in Chrome:

- [Translator API](https://developer.chrome.com/docs/ai/translator-api/)
- [Language Detection API](https://developer.chrome.com/docs/ai/language-detection)
- [Writer API](https://developer.chrome.com/docs/ai/writer-api)
- [Rewriter API](https://developer.chrome.com/docs/ai/rewriter-api)
- [Summarizer API](https://developer.chrome.com/docs/ai/summarizer-api/)
- [Prompt API](https://developer.chrome.com/docs/ai/prompt-api/)
- [Proofreader API](https://developer.chrome.com/docs/ai/proofreader-api/) (not yet available)

All these APIs provide a high-level and similar interface, making it easy to switch between them.
The general flow for using these APIs is as follows:

1. Check if the API is supported in the browser with an `if ("APIName" in window)` check.
2. Check the availability of the API and the model by testing the return value of `await APIName.availability();`, which can be one of the following:
    - `unavailable`: the API is not supported in the browser or the model is not available.
    - `available`: the API is supported and the model is available and ready to use.
    - `downloadable`: the API is supported but the model is not available and can be downloaded.
    - `downloading`: the API is supported but the model is currently being downloaded.
3. If the API is `available`, `downloadable`, or `downloading`, we can create an object to interact with the API by using the result of `await APIName.create(options)`. We can optionally pass in the `options` a callback function to be notified of the download progress. This is particularly useful for large models that are not yet downloaded.
4. Then we can ask the obtained object to perform the desired operation by calling the appropriate method with the required parameters. Many APIs support a `stream` option to get the result as a stream of events, which is useful for large inputs or outputs.

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
// The output should be: "Bonjour, monde !"
```

There may be some differences between the APIs, but the flow is generally the same.
For more examples, you can check the official [documentation](https://developer.chrome.com/docs/ai/built-in) and [my demo website](https://yostane.github.io/web-ai/) along with [its source code](https://github.com/yostane/web-ai).

## Transformer.js vs native AI API

The advantages of using the Built-in AI web API over transformers.js are:

- **No external dependencies**: You don't need to include any external libraries or frameworks, which reduces the size of your application and improves performance.
- **Native support**: The API is built into the browser, which means it can take advantage of the browser's capabilities and optimizations.
- **Download the model once**: The Built-in web AI APIs download the model once and reuse-it across the different APIs and across domains.
    This means that if many webapps use the same model, they will share the downloaded copy, which reduces the loading time and improves performance.
    This is the opposite of Transformers.js, which can download different models (with varying sizes) depending on the task, and they are not shared across different origins.
    This means that if many web applications use the same model, they will each download their own copy, which can increase loading times and bandwidth usage.

The advantages of using Transformers.js over the Built-in AI web API are:

- **More model options**: Transformers.js supports a wider range of models available at [Hugging Face Model Hub](https://huggingface.co/models), which may be more suitable for specific tasks.
- **Flexibility**: Transformers.js is a general-purpose library that can be used for a variety of tasks beyond just text generation, such as image processing and multi-modal tasks.
- **Community support**: Transformers.js is provided by HuggingFace which has a large and active community, which means you can find more resources, tutorials, and pre-trained models to help you get started.
- **Wider browser support**: Transformers.js can run using Wasm or Webgpu, meaning that it supports a broader range of devices and platforms.
    At the time of writing, built-in Web AI works only on Chrome, and some APIs require enabling feature flags or using a beta, development, or Canary build of Chrome.
- **Stable API**: Transformers.js is stable and relatively well-documented.
    At the time of writing, built-in web AI APIs are still evolving, and may not have the same level of stability and documentation.

To summarize, if we want to run AI in the browser, the safest choice is to use Transformers.js.
In the future, when built-in web AI becomes stable and available across browsers, it may become the default approach, and Transformers.js may become the alternative for more specific use cases.

## Browser AI vs server-side AI

Even though it is possible to run AI on the browser, there are still some limitations and trade-offs to consider when choosing between browser AI and server-side AI.

The advantages of using AI on the browser in favor of server based AI:

The advantages of using AI in the browser over server-based AI:

- **Offline capabilities**: Local web AI can work without an internet connection, making it more reliable in situations where connectivity is limited or unavailable.
- **Privacy and security**: By processing data locally, web AI can help protect user privacy and reduce the risk of data breaches associated with sending sensitive information to a server.
- **Easier to setup**: Web AI can be easier to set up and deploy, as it does not require server infrastructure or complex backend systems.
    In fact, a static HTML page can use web AI without any server-side code.
- **Less expensive**: Webapps that take advantage of local web AI can reduce costs associated with server maintenance, data transfer, and cloud computing resources.

The disadvantages of using AI on the browser in favor of server based AI:

The disadvantages of using AI in the browser compared to server-based AI:

- **Limited resources**: Browser-based AI may be limited by the device's hardware and performance capabilities, which can impact the complexity and size of the models that can be run.
- **Inconsistent performance**: The performance of browser-based AI can vary depending on the user's device and browser, leading to potential inconsistencies in user experience.
- **Less models and use cases**: While browser-based AI is growing, it may not yet support the same breadth of models and use cases as server-based solutions.
- **More control over the model**: Server-based AI can offer more control over the model and its environment, allowing for easier updates, maintenance, and customization.

## Conclusion

This post explored how to run AI directly on the browser.

This post explored how to run AI directly in the browser.
We introduced two ways to achieve this: using the built-in web AI APIs and using Transformers.js.
We discussed the advantages and disadvantages of each approach, helping you make an informed decision based on your specific use case.
The biggest advantages of using web AI are privacy and cost-effectiveness, and I believe we should move more in this direction.
We can even use Transformers.js for tasks that use small models and compute quickly.
Currently, server-side AI is the most reliable option for running AI workloads, especially for complex tasks that require significant computational resources.
However, if built-in web AI continues to improve, it will become a viable alternative for more complex use cases.
So, let's keep an eye on this exciting development.
