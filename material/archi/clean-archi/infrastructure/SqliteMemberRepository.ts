import type { Member } from "business-domain";
import type { MemberRepository } from "interfaces";
import sqlite3 from "sqlite3";

export class SqliteMemberRepository implements MemberRepository {
  setup(): void {
    const db = new sqlite3.Database(":memory:");
    db.serialize(() => {
      db.run(`CREATE TABLE IF NOT EXISTS Members (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          name Text NOT NULL,
          type Text NOT NULL,
          address Text NOT NULL`);
    });
    db.close();
  }

  add(member: Member): void {
    const db = new sqlite3.Database(":memory:");
    db.serialize(() => {
      const stmt = db.prepare(
        "INSERT INTO Members (name, type, address) VALUES (?, ?, ?)"
      );
      stmt.run(member.name, member.type, member.address);
      stmt.finalize();
    });
    db.close();
  }

  delete(memberId: number): void {
    const db = new sqlite3.Database(":memory:");
    db.serialize(() => {
      const stmt = db.prepare("DELETE FROM Members Where id = ?");
      stmt.run(memberId);
      stmt.finalize();
    });
    db.close();
  }
}
