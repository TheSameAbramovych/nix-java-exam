import React, {useContext} from "react";
import {NavContext} from "../../context/navState";
import "./Auth.css";

const Logout = () => {
    const {isLogin, updateToken} = useContext(NavContext);

    function logout() {
        updateToken(null)
    }

    let style = {marginLeft: "auto"};
    return (
        <div style={style}>
            {isLogin() && (
                <button className="logout-button" onClick={logout}>Logout</button>
            )}
        </div>
    );

}

export default Logout;
