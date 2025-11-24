import { MemberController } from "interfaces";
import { SqliteMemberRepository } from "./SqliteMemberRepository";
import { Member } from "business-domain";

const sqliteMemberRepository = new SqliteMemberRepository();
await sqliteMemberRepository.setup();
const memberController = new MemberController(sqliteMemberRepository);

await memberController.add(new Member(-1, "my Name", "subscriber", "home"));
await memberController.add(new Member(-1, "your Name", "free sub", "work"));

await memberController.delete(1);

console.log("all", await memberController.getAll());
