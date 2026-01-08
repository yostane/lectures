import { MemberUseCases } from "use-cases";
import { MemberEntity, MemberEntityMapper } from "./MemberEntity";
export { MemberEntity, MemberEntityMapper } from "./MemberEntity";

export interface MemberRepository {
  add(member: MemberEntity): Promise<void>;
  delete(memberId: number): Promise<void>;
  getAll(): Promise<MemberEntity[]>;
}

/**
 * Fait le lien entre les uses cases et l'infra
 */
export class MemberController {
  private readonly memberUseCases: MemberUseCases;
  private readonly memberMapper = new MemberEntityMapper();
  constructor(private memberRepository: MemberRepository) {
    this.memberUseCases = new MemberUseCases(this.memberRepository);
  }

  async add(member: MemberEntity): Promise<void> {
    const m = this.memberMapper.mapEntityToMember(member);
    await this.memberUseCases.add(m);
  }

  async delete(memberId: number): Promise<void> {
    await this.memberUseCases.delete(memberId);
  }

  async getAll(): Promise<MemberEntity[]> {
    const members = await this.memberUseCases.getAll();
    return members.map(this.memberMapper.mapMemberToEntity);
  }
}
