import { InMemoryMemberRepository } from "adapters";
import { MemberUseCase } from "use-cases";

console.log("Welcome to member cli");

const memberRepository = new InMemoryMemberRepository();
const memberUseCase = new MemberUseCase(memberRepository);

memberUseCase.add("Dupond", "dupond@mail.com");
memberUseCase.add("Durand", "durand@mail.com");

console.log("Members:", await memberUseCase.getAll());
