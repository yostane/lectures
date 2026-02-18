/**
 * This file will automatically be loaded by vite and run in the "renderer" context.
 * To learn more about the differences between the "main" and the "renderer" context in
 * Electron, visit:
 *
 * https://electronjs.org/docs/tutorial/process-model
 *
 * By default, Node.js integration in this file is disabled. When enabling Node.js integration
 * in a renderer process, please be aware of potential security implications. You can read
 * more about security risks here:
 *
 * https://electronjs.org/docs/tutorial/security
 *
 * To enable Node.js integration in this file, open up `main.ts` and enable the `nodeIntegration`
 * flag:
 *
 * ```
 *  // Create the browser window.
 *  mainWindow = new BrowserWindow({
 *    width: 800,
 *    height: 600,
 *    webPreferences: {
 *      nodeIntegration: true
 *    }
 *  });
 * ```
 */

import { ipcRenderer } from "electron";
import "./index.css";
import { hostname } from "node:os";

document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("#change-emoji-btn").addEventListener("click", () => {
    const emoji = document.querySelector("#emoji");
    emoji.innerHTML = emoji.innerHTML.startsWith("💖") ? "⚡️" : "💖";
    emoji.innerHTML += ` process ID: ${window.processId}`;
  });
  document
    .querySelector("#memory-info-btn")
    .addEventListener("click", async () => {
      const memoryInfoElement = document.querySelector("#memory-info");
      const memInfo = await window.getMemoryInfo();
      const hostName = await window.getHostName();
      memoryInfoElement.innerHTML = `private: ${memInfo.private}, shared ${memInfo.shared}`;
      memoryInfoElement.innerHTML += `host name ${hostName}`;
    });

  document.querySelector("#change-title-btn").addEventListener("click", () => {
    const titleInput = document.querySelector(
      "#title-input",
    ) as HTMLInputElement;
    const title = titleInput.value;
    window.setTitle(title);
  });
});
