import { InMemoryMemberRepository, MemberCommandHandler } from "adapters";
import { MemberUseCase } from "use-cases";
import { parseArgs } from "util";

const inMemoryRepository = new InMemoryMemberRepository();
const memberUseCase = new MemberUseCase(inMemoryRepository);
const memberCommandHandler = new MemberCommandHandler(memberUseCase);

// bun run index.ts --add name email
// bun run index.ts --list

const command = Bun.argv[2];

if (command === "--list") {
  console.log("Adding some test members");
  await memberCommandHandler.save("toto", "toto@mail.com");
  await memberCommandHandler.save("tata", "tata@mail.com");
  console.log("Showing members");
  await memberCommandHandler.showAll();
  process.exit(0);
}

if (command === "--add") {
  const name = Bun.argv[3];
  const email = Bun.argv[4];

  if (!name || !email) {
    console.error("name or email missing");
    process.exit(1);
  }
  await memberCommandHandler.save(name, email);
  process.exit(0);
}
