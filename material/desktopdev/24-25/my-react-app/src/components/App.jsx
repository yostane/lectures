import "../components/App.css";
import About from "./About";
import Calculator from "./Calculator";
import Counter from "./Counter";
import TodoList from "./TodoList";
import TodoListStored from "./TodoListStored";
import TodoListCrud from "./TodoListCrud";

export default function App() {
  return (
    <>
      Hello react
      <About />
      <Counter initialValue={2} />
      <Counter initialValue={5} />
      <Calculator op1InitialValue={5} op2InitialValue={-8} />
      <TodoList />
      <TodoListStored />
      <TodoListCrud />
    </>
  );
}
