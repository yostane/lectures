import type { Member } from "business-domain";

export interface MemberRepository {
  add(member: Member): void;
  delete(memberId: number): void;
}
