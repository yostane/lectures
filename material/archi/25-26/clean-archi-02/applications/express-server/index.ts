import { app } from "./src/server";

const port = process.env.PORT ?? 3000;

app.listen(port, (error) => {
  console.log("server started");
  if (error) {
    console.error(error);
  }
});
