import type { Member } from "entities";

export interface MemberRepository {
  save(member: Member): Promise<void>;
  findAll(): Promise<Member[]>;
}
