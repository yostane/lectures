import { Member } from "entities";
import type { MemberRepository } from "use-cases";

export class InMemoryMemberRepository implements MemberRepository {
  private members = new Map<string, Member>();

  async save(member: Member): Promise<void> {
    this.members.set(member.uuid, member);
  }

  async findById(id: string): Promise<Member> {
    const member = this.members.get(id);
    if (!member) {
      throw new Error(`Member with id ${id} not found`);
    }
    return member;
  }
}
