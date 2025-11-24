import type { Member } from "business-domain";
import type { MemberRepository } from "interfaces";
import sqlite3 from "sqlite3";

export class SqliteMemberRepository implements MemberRepository {
  setup() {
    const db = new sqlite3.Database(":memory:");
    db.serialize(() => {
      db.run(`CREATE TABLE IF NOT EXISTS MEMBERS (
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
        "INSERT INTO MEMBERS (name, type, address) VALUES (?, ?, ?)"
      );
      stmt.bind();
      stmt.run(member.name, member.type, member.address);
      stmt.finalize();
    });
    db.close();
  }

  delete(memberId: number): void {
    throw new Error("Method not implemented.");
  }
}

db.serialize(() => {
  db.run(`CREATE TABLE IF NOT EXISTS MEMBERS (
	  id INTEGER PRIMARY KEY AUTOINCREMENT,
   	name Text NOT NULL,
    type Text NOT NULL,
	  address Text NOT NULL`);

  const stmt = db.prepare("INSERT INTO lorem VALUES (?)");
  for (let i = 0; i < 10; i++) {
    stmt.run("Ipsum " + i);
  }
  stmt.finalize();

  db.each("SELECT rowid AS id, info FROM lorem", (err, row) => {
    console.log(row.id + ": " + row.info);
  });
});

db.close();
