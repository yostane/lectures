import { Member } from "business-domain";
import type { MemberRepository } from "interfaces";

export class MemberUseCases {
  constructor(private memberRepository: MemberRepository) {}

  async add(member: Member): Promise<void> {
    await this.memberRepository.add(member);
  }
  async delete(memberId: number): Promise<void> {
    await this.memberRepository.delete(memberId);
  }

  async getAll(): Promise<Member[]> {
    return await this.memberRepository.getAll();
  }
}
