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
  const todoItems = originalTodoItems;
  const todoElements = todoItems.map((todoItem) => (
    <li>
      id: {todoItem.id} - <b>{todoItem.title}</b> -{" "}
      <i>{todoItem.done ? "Done" : "Not done"}</i>
    </li>
  ));
  return <ul>{todoElements}</ul>;
}
