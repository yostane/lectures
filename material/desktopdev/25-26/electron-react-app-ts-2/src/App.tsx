import { Link, Outlet } from "react-router-dom";
import "./App.css";
import { Button, Grid, Stack } from "@mui/material";

function App() {
  return (
    <>
      <Grid container spacing={2}>
        <Grid size={4}>
          <Stack spacing={2}>
            <Link to="/home">Home</Link>
            <Link to="/about">About</Link>
            <Link to="/contact">Contact</Link>
          </Stack>
        </Grid>
        <Grid size={8}>
          <Outlet />
        </Grid>
      </Grid>
    </>
  );
}

export default App;
