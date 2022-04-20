import React from "react";
import NavState from "./context/navState";
import MainContent from "./components/MainContent";

function App() {
    return (
        <NavState>
            <MainContent/>
        </NavState>
    );
}

export default App;
