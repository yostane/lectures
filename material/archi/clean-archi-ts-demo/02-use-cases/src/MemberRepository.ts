import type { Member } from "entities";

export interface MemberRepository {
  save(member: Member): Promise<void>;
  findById(id: string): Promise<Member>;
}
