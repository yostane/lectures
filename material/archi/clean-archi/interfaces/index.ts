import type { Member } from "business-domain";
import { MemberUseCases } from "use-cases";

export interface MemberRepository {
  add(member: Member): void;
  delete(memberId: number): void;
}

/**
 * Fait le lien entre les uses cases et l'infra
 */
export class MemberController {
  private readonly memberUseCases;
  constructor(private memberRepository: MemberRepository) {
    this.memberUseCases = new MemberUseCases(this.memberRepository);
  }

  add(member: Member) {
    this.memberUseCases.add(member);
  }

  delete(memberId: number) {
    this.memberUseCases.delete(memberId);
  }
}
