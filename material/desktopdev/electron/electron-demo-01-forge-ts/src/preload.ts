// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts
import { contextBridge } from "electron";
import fs from "node:fs/promises";

contextBridge.exposeInMainWorld("versions", {
  node: () => process.versions.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
});

window.addEventListener("DOMContentLoaded", async () => {
  const files = await fs.readdir(".");
  const html = files.map((file) => `<li>${file}</li>`).join("\n");
  document.getElementById("files").innerHTML = `<ul>${html}</ul>`;
  console.log(files);
});
