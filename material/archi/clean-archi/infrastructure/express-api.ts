import { MemberController } from "interfaces";
import { SqliteMemberRepository } from "./SqliteMemberRepository";
import { MemberEntity } from "interfaces";
import express from "express";
import bodyParser from "body-parser";

const sqliteMemberRepository = new SqliteMemberRepository();
await sqliteMemberRepository.setup();
const memberController = new MemberController(sqliteMemberRepository);

const app = express();
app.use(bodyParser.json());

app.get("/", async (req, res) => {
  const members = await memberController.getAll();
  res.send(members);
});

app.post("/", async (req, res) => {
  const member: MemberEntity = req.body;
  await memberController.add(member);
  res.sendStatus(201);
});

app.delete("/:id", async (req, res) => {
  const memberId = +req.params.id;
  await memberController.delete(memberId);
  res.sendStatus(200);
});

const port = 3000;
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
