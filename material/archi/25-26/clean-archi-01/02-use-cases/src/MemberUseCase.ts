import { Member } from "entities";
import type { MemberRepository } from "./MemberRepository";
import { randomUUIDv7 } from "bun";

export class MemberUseCase {
  constructor(private memberReposiroty: MemberRepository) {}

  async add(name: string, email: string): Promise<void> {
    const uuid = randomUUIDv7();
    const member = new Member(uuid, name, email);
    await this.memberReposiroty.save(member);
  }
}
