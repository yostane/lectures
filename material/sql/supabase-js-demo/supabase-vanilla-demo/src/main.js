import { createClient } from "@supabase/supabase-js";
import { SUPABASE_KEY, SUPABASE_URL } from "./local";

// Create a single supabase client for interacting with your database
const supabase = createClient(SUPABASE_URL, SUPABASE_KEY);

async function addUser() {
  const { error } = await supabase.from("spakers").insert({
    email: `mordor-${(Math.random() * 100_000).toFixed(0)}@lotr.com`,
    status: "validated",
    details: `{
      "movie": "Lord of the Rings"
    }`,
  });
  if (error) {
    console.error(error);
  }
}

async function selectAll() {
  const { data, error } = await supabase.from("spakers").select();
  if (error) {
    console.error(error);
    return;
  }
  const ul = document.querySelector("#users-list");
  ul.innerHTML = "";
  for (const row of data) {
    const liContent = `<li>email: ${row.email}. Status: ${row.status}. Details: ${row.details}</li>`;
    ul.innerHTML += liContent;
  }
}

document.querySelector("#app").innerHTML = `
  <div>
    Hello
    <button id="add-user-btn">Add user</button>
    <button id="select-all-btn">Select all</button>
    <ul id="users-list"></ul>
  </div>
`;

window.addEventListener("DOMContentLoaded", async () => {
  document
    .querySelector("#add-user-btn")
    .addEventListener("click", () => addUser());

  document
    .querySelector("#select-all-btn")
    .addEventListener("click", () => selectAll());
});
