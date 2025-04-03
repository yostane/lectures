import { useEffect, useState } from "react";

const originalTodoItems = [
  {
    id: 1,
    title: "Cours de react",
    done: false,
  },
  {
    id: 2,
    title: "Cours d'ElectronJS",
    done: false,
  },
  {
    id: 3,
    title: "Filter, map",
    done: true,
  },
];

export default function TodoListStored() {
  const [todoItems, setTodoItems] = useState(originalTodoItems);

  // Hook (commence par use) qui synchronise l'état avec une donnée externe
  // On doit lui spécifier en callback la donnée à charger et en deuxième argument les états qui en dépendend
  useEffect(() => {
    const storageTodoItemsString = localStorage.getItem("todoItems");
    if (storageTodoItemsString != null) {
      const storageTodoItems = JSON.parse(storageTodoItemsString);
      setTodoItems(storageTodoItems);
    }
  }, [todoItems]);

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
    <li>
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
      <h2>Todo List local storage</h2>
      <button onClick={() => setAllTodosDone(true)}>All done</button>
      <button onClick={() => setAllTodosDone(false)}>All undone</button>
      <ul>{todoElements}</ul>{" "}
    </>
  );
}
