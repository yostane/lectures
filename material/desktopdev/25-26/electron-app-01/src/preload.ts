// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts

import { contextBridge, ipcRenderer } from "electron";

contextBridge.exposeInMainWorld("processId", process.pid);
contextBridge.exposeInMainWorld("getMemoryInfo", process.getProcessMemoryInfo);

async function getHostName() {
  return ipcRenderer.invoke("getHostNameFromOS");
}
contextBridge.exposeInMainWorld("getHostName", getHostName);
