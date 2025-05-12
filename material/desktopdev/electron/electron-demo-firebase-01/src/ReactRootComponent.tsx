import AuthenticationComponent from "./components/AuthenticationComponent";
import FirestoreCrudComponent from "./components/FirestoreCrudComponent";

export default function ReactRootComponent() {
  return (
    <>
      <h1>Hello react 💖 electronnJS</h1>
      <AuthenticationComponent />
      <FirestoreCrudComponent />
    </>
  );
}
