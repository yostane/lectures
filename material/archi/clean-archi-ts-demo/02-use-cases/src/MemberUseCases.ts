export class MemberUseCases {
  constructor(private memberRepository: MemberRepository) {}

  async add(name: string, email: string): Promise<void> {
    const member = new Member(name, email);
    await this.memberRepository.add(member);
  }

  async delete(memberId: number): Promise<void> {
    await this.memberRepository.delete(memberId);
  }

  async getAll(): Promise<Member[]> {
    return await this.memberRepository.getAll();
  }
}
