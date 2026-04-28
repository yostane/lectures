import express from "express";
import { MemberController } from "controllers";
import { MemberUseCase, type MemberRepository } from "use-cases";

function generateServer(memberRepository: MemberRepository): express.Express {
  const memberUseCase = new MemberUseCase(memberRepository);
  const memberController = new MemberController(memberUseCase);
  const app = express();
  app.use(express.json());

  app.get("/members", async (req, res) => {
    res.json(await memberController.getAll());
  });

  app.post("/members", async (req, res) => {
    const name = req.body.name;
    const email = req.body.email;
    await memberController.save(name, email);
    res.send();
  });
  return app;
}
