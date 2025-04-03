import { useEffect, useState } from "react";

export default function TodoListCrud() {
  const [todoItems, setTodoItems] = useState([]);

  // Hook (commence par use) qui synchronise l'état avec une donnée externe
  // On doit lui spécifier en callback la donnée à charger et
  // en deuxième argument les états qui en dépendent et qui ne se font pas set
  useEffect(() => {
    const storageTodoItemsString = localStorage.getItem("todoItems");
    if (storageTodoItemsString != null) {
      const storageTodoItems = JSON.parse(storageTodoItemsString);
      setTodoItems(storageTodoItems);
    }
  }, []);

  function saveAndSetTodoItems(todoItems) {
    localStorage.setItem("todoItems", JSON.stringify(todoItems));
    setTodoItems(todoItems);
  }

  function handleCheck(checkedTodoItem) {
    const newTodoItems = todoItems.map((todoItem) => {
      if (todoItem.id === checkedTodoItem.id) {
        todoItem.done = !todoItem.done;
      }
      return todoItem;
    });
    saveAndSetTodoItems(newTodoItems);
  }

  function setAllTodosDone(done) {
    saveAndSetTodoItems(
      todoItems.map((todoItem) => {
        todoItem.done = done;
        return todoItem;
      })
    );
  }

  const todoElements = todoItems.map((todoItem) => (
    <li key={todoItem.id}>
      id: {todoItem.id} - <b>{todoItem.title}</b> -{" "}
      <i>{todoItem.done ? "Done" : "Not done"}</i>
      <input
        type="checkbox"
        name="done"
        checked={todoItem.done}
        onChange={() => handleCheck(todoItem)}
      />
    </li>
  ));
  return (
    <>
      <h2>Todo List CRUD + localStorage</h2>
      <button onClick={() => setAllTodosDone(true)}>All done</button>
      <button onClick={() => setAllTodosDone(false)}>All undone</button>
      <div>
        <label htmlFor="title">Title:</label>
        <input type="text" name="title" placeholder="My new task" />
      </div>
      <ul>{todoElements}</ul>{" "}
    </>
  );
}
