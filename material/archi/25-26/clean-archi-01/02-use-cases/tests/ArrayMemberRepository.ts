import { Member } from "entities";
import type { MemberRepository } from "../src/MemberRepository";

export class ArrayMemberRepository implements MemberRepository {
  members = Array<Member>();

  async save(member: Member): Promise<void> {
    const index = this.members.findIndex((m) => m.uuid == member.uuid);
    if (index === -1) {
      this.members.push(member);
    } else {
      this.members[index] = member;
    }
  }

  async getAll(): Promise<Member[]> {
    return [...this.members];
  }
}
