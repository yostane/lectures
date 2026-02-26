import { createClient } from "@supabase/supabase-js";
import { SUPABASE_KEY, SUPABASE_URL } from "./local";

const supabase = createClient(SUPABASE_URL, SUPABASE_KEY);

async function signIn(email) {
  const { data, error } = await supabase.auth.signInWithPassword({
    email: email,
    password: email,
  });
  if (error) {
    console.error(error);
    return;
  }
  console.log("Sign in success", data);
}

async function addUser() {
  const { error } = await supabase.from("speakers").insert({
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
  const { data, error } = await supabase.from("speakers").select();
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
    <div>
    <input id="email-input" value="admin@admin.com">
    <button id="signin-btn">Sign in</button>
    </div>
    <div>
    <button id="add-user-btn">Add user</button>
    <button id="select-all-btn">Select all</button>
    </div>
    <ul id="users-list"></ul>
  </div>
`;

window.addEventListener("DOMContentLoaded", async () => {
  document
    .querySelector("#add-user-btn")
    .addEventListener("click", async () => await addUser());

  document
    .querySelector("#select-all-btn")
    .addEventListener("click", async () => await selectAll());

  document.querySelector("#signin-btn").addEventListener("click", async () => {
    const email = document.querySelector("#email-input").value;
    await signIn(email);
  });
});
