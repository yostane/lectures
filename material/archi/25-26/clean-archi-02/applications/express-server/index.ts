import express from "express";

const app = express();

const port = process.env.PORT ?? 3000;

app.use("/members/list", (req, res) => {});

app.use("/members/add", (req, res) => {});

app.listen(port, (error) => {
  console.log("server started");
  if (error) {
    console.error(error);
  }
});
