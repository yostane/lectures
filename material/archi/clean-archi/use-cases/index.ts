import { Member } from "business-domain";
import type { MemberRepository } from "interfaces";

export class MemberUseCases {
  constructor(private memberRepository: MemberRepository) {}

  add(member: Member): void {
    this.memberRepository.add(member);
  }
  delete(memberId: number): void {
    this.memberRepository.delete(memberId);
  }
}
