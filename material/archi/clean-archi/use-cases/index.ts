import { Member } from "business-domain";

export class MemberUseCases {
  constructor(private memberRepository: MemberRepository) {}

  add(member: Member): void {}
  delete(memberId: Member): void {}
}
