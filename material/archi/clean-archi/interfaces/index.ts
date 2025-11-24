import type { Member } from "business-domain";
import { MemberUseCases } from "use-cases";

export interface MemberRepository {
  add(member: Member): Promise<void>;
  delete(memberId: number): Promise<void>;
  getAll(): Promise<Member[]>;
}

/**
 * Fait le lien entre les uses cases et l'infra
 */
export class MemberController {
  private readonly memberUseCases: MemberUseCases;
  constructor(private memberRepository: MemberRepository) {
    this.memberUseCases = new MemberUseCases(this.memberRepository);
  }

  async add(member: Member): Promise<void> {
    await this.memberUseCases.add(member);
  }

  async delete(memberId: number): Promise<void> {
    await this.memberUseCases.delete(memberId);
  }

  async getAll(): Promise<Member[]> {
    return await this.memberRepository.getAll();
  }
}
