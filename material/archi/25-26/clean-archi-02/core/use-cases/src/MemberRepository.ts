import { Member } from "entities";

export interface MemberRepository {
  save(member: Member): Promise<void>;
  getAll(): Promise<Member[]>;
}
