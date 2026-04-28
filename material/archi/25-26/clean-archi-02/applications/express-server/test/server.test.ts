import supertest from "supertest";
import { generateServer } from "../src/server";
import { expect, test } from "bun:test";
import { InMemoryMemberRepository } from "in-memory-repository";

test("should add members", (done) => {
  const member = {
    name: "toto",
    email: "tata@mail.com",
  };
  const app = generateServer(new InMemoryMemberRepository());
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
          expect(data.name).toEqual("dfsdf");
          expect(data.email).toEqual(member.email);
          done();
        });
    });
});

test("should list members", () => {
  const app = generateServer(new InMemoryMemberRepository());
  supertest(app).get("/members").expect(200);
});
