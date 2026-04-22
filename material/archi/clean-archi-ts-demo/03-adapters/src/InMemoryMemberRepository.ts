import { Member } from "entities";
import type { MemberRepository } from "use-cases";

export class InMemoryMemberRepository implements MemberRepository {
  private members = new Map<string, Member>();

  async save(member: Member): Promise<void> {
    this.members.set(member.uuid, member);
  }

  async findAll(): Promise<Member[]> {
    return Array.from(this.members.values());
  }
}
