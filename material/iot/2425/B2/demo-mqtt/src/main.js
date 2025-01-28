import "./style.css";
import javascriptLogo from "./javascript.svg";
import viteLogo from "/vite.svg";
import { setupCounter } from "./counter.js";
import mqtt from "mqtt"

document.querySelector("#app").innerHTML = `
  <div>
    <a href="https://vite.dev" target="_blank">
      <img src="${viteLogo}" class="logo" alt="Vite logo" />
    </a>
    <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank">
      <img src="${javascriptLogo}" class="logo vanilla" alt="JavaScript logo" />
    </a>
    <h1>Hello Vite with MQTT!</h1>
    <div class="card">
      <button id="counter" type="button"></button>
    </div>
    <p class="read-the-docs">
      Click on the Vite logo to learn more
    </p>
  </div>
`;

setupCounter(document.querySelector("#counter"));

const client = mqtt.connect(import.meta.env.VITE_MQTT_URL, {
  clientId: "Navigateur"
});

client.on("connect", async () => {
  await client.subscribeAsync("test");
  await client.publishAsync("presence", "Client web connecté")
});

client.on("message", (topic, message) => {
  console.log(topic, message.toString());
});
