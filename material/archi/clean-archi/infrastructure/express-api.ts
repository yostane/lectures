import { MemberController } from "interfaces";
import { SqliteMemberRepository } from "./SqliteMemberRepository";
import { Member } from "business-domain";
import express from "express";
import bodyParser from "body-parser";

const app = express();
app.use(bodyParser.json());

const sqliteMemberRepository = new SqliteMemberRepository();
await sqliteMemberRepository.setup();
const memberController = new MemberController(sqliteMemberRepository);

app.get("/", (req, res) => {
  const members = memberController.getAll();
  res.send(members);
});

app.post("/", (req, res) => {
  const member: Member = req.body;
  memberController.add(member);
  res.sendStatus(201);
});

app.delete("/:id", (req, res) => {
  const memberId = +req.params.id;
  memberController.delete(memberId);
  res.sendStatus(200);
});

const port = 3000;
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
