import type { MemberUseCase } from "use-cases";

class MemberCommandHandler {
  constructor(private memberUseCase: MemberUseCase) {}

  async save(name: string, email: string): Promise<void> {
    console.log("Adding user");
    try {
      await this.memberUseCase.add(name, email);
      console.log("User added");
    } catch (e) {
      console.error("Failed to add user", e);
    }
  }

  async showAll(): Promise<void> {
    console.log("Showing members");
    try {
      const members = this.memberUseCase.getAll();
      console.log("Current members", members);
    } catch (e) {
      console.error("Failed to list members", e);
    }
  }
}
