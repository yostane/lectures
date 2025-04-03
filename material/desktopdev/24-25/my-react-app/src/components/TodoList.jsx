import { useState } from "react";

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

export default function TodoList() {
  const [todoItems, setTodoItems] = useState(originalTodoItems);

  function handleCheck(checkedTodoItem) {
    // Création d'une nouvelle liste qui change le done de l'émément coché
    const newTodoItems = todoItems.map((todoItem) => {
      // On change l'état done de l'élément coché
      if (todoItem.id === checkedTodoItem.id) {
        todoItem.done = !todoItem.done;
      }
      return todoItem;
    });
    setTodoItems(newTodoItems);
  }

  function setAllTodosDone(done) {
    setTodoItems(
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
      <h2>todo list</h2>
      <button onClick={() => setAllTodosDone(true)}>All done</button>
      <button onClick={() => setAllTodosDone(false)}>All undone</button>
      <ul>{todoElements}</ul>
    </>
  );
}
