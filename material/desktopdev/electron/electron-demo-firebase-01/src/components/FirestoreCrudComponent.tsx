// List d'articles récupérés depuis firestore
import { useState } from "react";
import { app } from "../firebase";
import {
  collection,
  doc,
  getDocs,
  getFirestore,
  setDoc,
} from "firebase/firestore";
import ShoppingItem from "./ShoppingItem";

type ShoppingItem = {
  id?: string;
  name: string;
  price: number;
};

export default function FirestoreCrudComponent() {
  const [items, setItems] = useState<ShoppingItem[]>([]);
  const [name, setName] = useState("Valo");
  const [price, setPrice] = useState(0);

  const itemList = items.map((item) => (
    <li key={item.id}>
      <ShoppingItem name={item.name} price={item.price} />
    </li>
  ));

  async function addItem() {
    const itemToAdd: ShoppingItem = {
      name,
      price,
    };
    const firestore = getFirestore(app);
    const itemsCollection = collection(firestore, "ShoppingItems");
    const newDoc = doc(itemsCollection);
    await setDoc(newDoc, itemToAdd);
    await loadItems();
  }

  async function loadItems() {
    const firestore = getFirestore(app);
    const itemsCollection = collection(firestore, "ShoppingItems");
    const docsSnapshot = await getDocs(itemsCollection);
    const loadedItems = docsSnapshot.docs.map((doc) => ({
      name: doc.data().name,
      price: doc.data().price,
      id: doc.id,
    }));
    setItems(loadedItems);
  }

  return (
    <div>
      <div className="form-group">
        <p>Ajout d'un article</p>
        <div>
          <label htmlFor="name">Nom :</label>
          <input
            name="name"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="price">Prix :</label>
          <input
            name="price"
            type="number"
            min={0}
            value={price}
            onChange={(e) => setPrice(+e.target.value)}
          />
        </div>
        <div>
          <button onClick={addItem}>Ajouter</button>
        </div>
      </div>
      <button onClick={loadItems}>loadItems</button>
      <ul>{itemList}</ul>
    </div>
  );
}
