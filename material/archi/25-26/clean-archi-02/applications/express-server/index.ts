import { InMemoryMemberRepository } from "in-memory-repository";
import { generateServer } from "./src/server";

const app = generateServer(new InMemoryMemberRepository());
const port = process.env.PORT ?? 3000;

app.listen(port, (error) => {
  console.log("server started");
  if (error) {
    console.error(error);
  }
});
