import { Member } from "business-domain";
import type { MemberRepository } from "interfaces";
import sqlite3 from "sqlite3";

export class SqliteMemberRepository implements MemberRepository {
  private readonly db = new sqlite3.Database(":memory:");
  async setup(): Promise<void> {
    const p = new Promise<void>((resolve, reject) => {
      this.db.serialize(() => {
        this.db.run(`CREATE TABLE Members (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          name Text NOT NULL,
          type Text NOT NULL,
          address Text NOT NULL)`);
        resolve();
      });
    });
    return p;
  }

  async add(member: Member): Promise<void> {
    return new Promise<void>((resolve, reject) => {
      this.db.serialize(() => {
        const stmt = this.db.prepare(
          "INSERT INTO Members (name, type, address) VALUES (?, ?, ?)"
        );
        stmt.run(member.name, member.type, member.address);
        stmt.finalize();
        resolve();
      });
    });
  }

  async delete(memberId: number): Promise<void> {
    return new Promise<void>((resolve, reject) => {
      this.db.serialize(() => {
        const stmt = this.db.prepare("DELETE FROM Members Where id = ?");
        stmt.run(memberId);
        stmt.finalize();
        resolve();
      });
    });
  }

  async getAll(): Promise<Member[]> {
    return new Promise<Member[]>((resolve, reject) => {
      this.db.serialize(() => {
        const stmt = this.db.prepare("Select * from Members");
        stmt.all<Member>((err, rows) => {
          console.log("row", rows);
          const members = rows.map(
            (r) => new Member(r.id, r.name, r.type, r.address)
          );
          stmt.finalize();
          resolve(members);
        });
      });
    });
  }
}
