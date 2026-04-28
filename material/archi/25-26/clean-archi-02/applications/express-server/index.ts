import express from "express";
import { InMemoryMemberRepository } from "in-memory-repository";
import { MemberController } from "controllers";
import { MemberUseCase } from "use-cases";

const inMemoryRepository = new InMemoryMemberRepository();
const memberUseCase = new MemberUseCase(inMemoryRepository);
const memberController = new MemberController(memberUseCase);

const app = express();
app.use(express.json());

const port = process.env.PORT ?? 3000;

app.get("/members", async (req, res) => {
  res.json(await memberController.getAll());
});

app.post("/members", async (req, res) => {
  const name = req.body.name;
  const email = req.body.email;
  await memberController.save(name, email);
  res.send();
});

app.listen(port, (error) => {
  console.log("server started");
  if (error) {
    console.error(error);
  }
});
