import { MemberController } from "interfaces";
import { SqliteMemberRepository } from "./SqliteMemberRepository";
import { Member } from "business-domain";

const sqliteMemberRepository = new SqliteMemberRepository();
sqliteMemberRepository.setup();
const memberController = new MemberController(sqliteMemberRepository);

memberController.add(new Member(-1, "my Name", "subscriber", "home"));
memberController.add(new Member(-1, "your Name", "free sub", "work"));

memberController.delete(1);
