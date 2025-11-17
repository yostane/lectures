import "./style.css";
import { MQTT_PASSWORD, MQTT_SERVER, MQTT_USER } from "./constants";
import mqtt from "mqtt";

// On attend le chargement du DOM avant d'exécuter le code
window.addEventListener("DOMContentLoaded", () => {
  // Utiliser la TLS WebSocket URL et la préfixer avec wss://
  const client = mqtt.connect(MQTT_SERVER, {
    clientId: "Navigateur",
    username: MQTT_USER,
    password: MQTT_PASSWORD,
  });

  const messagesElement = document.getElementById("messages");
  const temperatureHistoryElement = document.getElementById("temp-hist");
  const messageSubmitButton = document.getElementById("messageSubmitButton");
  const messageInput = document.getElementById("messageInput");

  // Connection au broker
  // Quand la connexion réussit, on effectue une action de souscription et une publication
  client.on("connect", async () => {
    await client.subscribeAsync("#");
    messagesElement.innerHTML += "<li>Connecté au broker MQTT</li>";
  });

  // quand on reçoit un message, on log son topic et son contenu
  client.on("message", (topic, message) => {
    console.log("Reveived message", message, "for topic", topic);
    messagesElement.innerHTML += `Got message on topic ${topic}: ${message.toString()}<br/>`;
    if (topic.includes("temp")) {
      const parsedMessage = JSON.parse(message);
      temperatureHistoryElement.innerHTML += `${parsedMessage.value}, `;
    }
  });

  messageSubmitButton.addEventListener("click", () => {
    const message = messageInput.value;
    client.publish("test", JSON.stringify({ value: message }));
  });
});
