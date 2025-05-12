import "./ShoppingItem.css";

type ShoppingItemPropos = {
  name: string;
  price: number;
};

export default function ShoppingItem(props: ShoppingItemPropos) {
  return (
    <div className="shopping-item">
      <strong>{props.name}</strong>: <em>{props.price} €</em>
    </div>
  );
}
