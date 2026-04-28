import supertest from "supertest";
import { app } from "../src/server";
import { test } from "bun:test";

test("should add members", () => {
  const member = {
    name: "toto",
    email: "tata@mail.com",
  };

  supertest(app)
    .post("/members")
    .send(member)
    .set("Accept", "Application/json")
    .expect("Content-Type", "Application/json")
    .expect(200)
    .expect((res) => {
      res.body[0].name = member.name;
      res.body[1].email = member.email;
    });
});

test("should list members", () => {
  supertest(app).get("/members").expect(200);
});
