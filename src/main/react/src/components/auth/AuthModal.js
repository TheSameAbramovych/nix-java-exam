import React, {useContext, useState} from "react";
import LoginModal from "./LoginModal";
import RegistrationModal from "./RegistrationModal";

function AuthModal() {
    const login = "login";
    const registration = "registration";
    const [activeTab, setActiveTab] = useState(login);

    function changeTab(){
        if (login === activeTab) {
            setActiveTab(registration)
        } else {
            setActiveTab(login)
        }
    }

    return (
        <div>
            {login === activeTab && (<LoginModal changeTab={changeTab}/>)}
            {registration === activeTab && (<RegistrationModal changeTab={changeTab}/>)}
        </div>
    )
}

export default AuthModal;