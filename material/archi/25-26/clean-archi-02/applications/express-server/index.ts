import { InMemoryMemberRepository } from "in-memory-repository";
import { generateServer } from "./src/server";
import { SqliteMemberRepository } from "sqlite-repository";

const app = generateServer(new SqliteMemberRepository());
const port = process.env.PORT ?? 3000;

app.listen(port, (error) => {
  console.log("server started");
  if (error) {
    console.error(error);
  }
});
