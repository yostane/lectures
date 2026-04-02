import { useState, useEffect } from "react";
import { supabase } from "../utils/supabase";
import type { Task } from "../model/Task";

export default function Home() {
  const [tasks, setTasks] = useState(Array<Task>());

  useEffect(() => {
    async function loadTasks() {
      const selectResult = await supabase.from("tasks").select();
      console.log("select", selectResult);
      const tasks = selectResult.data;
      console.log("tasks", tasks);
      if (tasks) {
        setTasks(tasks);
      }
    }

    loadTasks();
  }, []);

  return (
    <>
      <h1>My tasks</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.title}>{task.content}</li>
        ))}
      </ul>
    </>
  );
}
