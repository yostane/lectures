import { expect, test } from "bun:test";
import { MemberUseCase } from "../src/MemberUseCase";
import { ArrayMemberRepository } from "./ArrayMemberRepository";

test("Should add member", async () => {
  const memberUseCase = new MemberUseCase(new ArrayMemberRepository());
  const name = "toto";
  const email = "tata@mail.com";
  await memberUseCase.add(name, email);
  const members = await memberUseCase.getAll();
  expect(members.length).toBe(1);
  expect(members[0]?.name).toBe(name);
  expect(members[0]?.email).toBe(email);
});
