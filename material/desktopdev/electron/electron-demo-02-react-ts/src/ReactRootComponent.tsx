import ShoppingItem from "./components/ShoppingItem";

export default function ReactRootComponent() {
  return (
    <>
      <h1>Hello react 💖 electronnJS</h1>
      <ShoppingItem name="mario all stars" price={44} />
      <ShoppingItem name="Zelda" price={60} />
    </>
  );
}
