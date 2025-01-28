import "./style.css";
import javascriptLogo from "./javascript.svg";
import viteLogo from "/vite.svg";
import { setupCounter } from "./counter.js";
// de là
import mqtt from "mqtt"
// Connection au broker
const client = mqtt.connect(import.meta.env.VITE_MQTT_URL, {
  clientId: "Navigateur"
});
// Quand la connexion réussit, on effectue une action de souscription et une publication
client.on("connect", async () => {
  await client.subscribeAsync("test");
  await client.publishAsync("presence", "Client web connecté")
});
// quand on reçoit un message, on log son topic et son contenu
client.on("message", (topic, message) => {
  console.log(topic, message.toString());
});
// jusque là

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
