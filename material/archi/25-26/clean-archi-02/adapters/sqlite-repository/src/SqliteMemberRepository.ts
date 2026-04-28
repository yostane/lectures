import type { Member } from "entities";
import { MemberRepository } from "use-cases";
import { SQL } from "bun";

export class SqliteMemberRepository implements MemberRepository {
  readonly sql: SQL;
  constructor(dbname: string = "data.sqlite") {
    this.sql = new SQL(`sqlite://${dbname}`);
    this.setup();
  }

  private async setup() {
    await this.sql`CREATE TABLE IF NOT EXISTS
    members (
      uuid text unique, name text, email text unique
    )`;
  }

  async getAll(): Promise<Member[]> {
    return await this.sql`SELECT * FROM members`;
  }

  async save(member: Member): Promise<void> {
    await this.sql`INSERT INTO members(uuid, name, email)
    VALUES (${member.uuid}, ${member.name}, ${member.email})`;
  }
}
