import { Member } from "business-domain";

export class MemberEntity {
  constructor(
    public id: number,
    public name: string,
    public type: string,
    public address: string
  ) {}
}

export class MemberEntityMapper {
  mapMemberToEntity(member: Member): MemberEntity {
    return new MemberEntity(
      member.id,
      member.name,
      member.type,
      member.address
    );
  }

  mapEntityToMember(memberEntity: MemberEntity): Member {
    return new Member(
      memberEntity.id,
      memberEntity.name,
      memberEntity.type,
      memberEntity.address
    );
  }
}
