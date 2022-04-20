import React, {useContext} from "react";
import MainMenu from "./navigationMenu/MainMenu";
import Dashboard from "./dashboard/Dashboard";
import {NavContext} from "../context/navState";
import AuthModal from "./auth/AuthModal";


function MainContent() {
    const {activeView, isLogin} = useContext(NavContext);

    return (
        <div>
            <MainMenu/>
            <AuthModal/>
            {"dashboard" === activeView && isLogin() && (<Dashboard/>)}
        </div>
    )
}

export default MainContent;
