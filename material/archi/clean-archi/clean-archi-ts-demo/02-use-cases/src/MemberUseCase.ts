import { Member } from "entities";
import type { MemberRepository } from "./MemberRepository";
import { randomUUIDv7 } from "bun";

export class MemberUseCase {
  constructor(private memberRepository: MemberRepository) {}

  async add(name: string, email: string): Promise<void> {
    const member = new Member(randomUUIDv7(), name, email);
    await this.memberRepository.save(member);
  }

  async getAll(): Promise<Member[]> {
    return await this.memberRepository.findAll();
  }
}
