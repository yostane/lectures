import supertest from "supertest";
import { generateServer } from "../src/server";
import { afterEach, beforeEach, expect, test } from "bun:test";
import { SqliteMemberRepository } from "sqlite-repository";

let repository: SqliteMemberRepository;
const path = "test.sqlite";

beforeEach(async () => {
  repository = new SqliteMemberRepository(path);
});

afterEach(async () => {
  const file = Bun.file(path);
  if (await file.exists()) {
    await file.delete();
  }
});

test("should add members", (done) => {
  const member = {
    name: "toto",
    email: "tata@mail.com",
  };
  const app = generateServer(repository);
  const agent = supertest(app);
  agent
    .post("/members")
    .send(member)
    .set("Accept", "Application/json")
    .expect("Content-Type", "Application/json")
    .expect(200)
    .end(() => {
      agent
        .get("/members")
        .expect(200)
        .then((res) => {
          const data = res.body[0];
          expect(data.name).toEqual(member.name);
          expect(data.email).toEqual(member.email);
          done();
        });
    });
});

test("should list members", () => {
  const app = generateServer(repository);
  supertest(app).get("/members").expect(200);
});
