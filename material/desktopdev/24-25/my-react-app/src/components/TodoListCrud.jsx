import { useEffect, useState } from "react";

export default function TodoListCrud() {
  const [todoItems, setTodoItems] = useState([]);
  const [newTodoItemTitle, setNewTodoItemTitle] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    const storageTodoItemsString = localStorage.getItem("todoItems");
    if (storageTodoItemsString != null) {
      const storageTodoItems = JSON.parse(storageTodoItemsString);
      setTodoItems(storageTodoItems);
    }
  }, []);

  function addTodoItem() {
    if (newTodoItemTitle.length == 0) {
      setErrorMessage("Incorrect length");
      return;
    }
    setErrorMessage("");
    const todoItem = {
      id: todoItems.length + 1,
      title: newTodoItemTitle,
      done: false,
    };
    // ... spread operator
    // ...todoItems => todoItems[0], todoItems[1], ...
    // Création d'une nouvelle liste qui reprend todoItems + todoItem
    const newTodoItems = [...todoItems, todoItem];
    saveAndSetTodoItems(newTodoItems);
  }

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

  const style = {
    border: "1px solid green",
    "border-radius": "5px",
    "background-color": "#FAF",
  };
  return (
    <div style={style}>
      <h2>Todo List CRUD + localStorage</h2>
      <button onClick={() => setAllTodosDone(true)}>All done</button>
      <button onClick={() => setAllTodosDone(false)}>All undone</button>
      <div>
        <label htmlFor="title">Title:</label>
        <input
          type="text"
          name="title"
          minLength={1}
          placeholder="My new task"
          value={newTodoItemTitle}
          onChange={(event) => setNewTodoItemTitle(event.target.value)}
        />
        <button onClick={addTodoItem}>Add</button>
        <button onClick={() => addTodoItem()}>Add</button>
        <br />
        {errorMessage}
      </div>
      <ul>{todoElements}</ul>{" "}
    </div>
  );
}
