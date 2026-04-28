import type { Member } from "entities";
import type { MemberRepository } from "use-cases";

export class InMemoryMemberRepository implements MemberRepository {
  private readonly members = new Map<string, Member>();
  async save(member: Member): Promise<void> {
    this.members.set(member.uuid, member);
  }

  async getAll(): Promise<Member[]> {
    return this.members.values().toArray();
  }
}
