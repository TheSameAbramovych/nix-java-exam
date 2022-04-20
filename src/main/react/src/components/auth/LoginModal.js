import React, {useContext, useState} from "react";
import {NavContext} from "../../context/navState";
import "./Auth.css";
import AuthService from "../../service/AuthService";

function LoginModal(props) {
    const {isLogin, updateToken} = useContext(NavContext);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");

    function submit(event) {
        AuthService.login(login, password, updateToken)
        event.preventDefault();
    }

    return (
        <div>
            {!isLogin() && (
                <div className="modal">
                    <form className="login-form" onSubmit={submit}>
                        <h3>Login Here</h3>
                        <label htmlFor="login">Login</label>
                        <input
                            id="login"
                            value={login}
                            onChange={(event) => {
                                setLogin(event.target.value);
                            }}
                        />
                        <label htmlFor="password">Password</label>
                        <input
                            id="password"
                            type="password"
                            value={password}
                            onChange={(event) => {
                                setPassword(event.target.value);
                            }}
                        />
                        <button className="login-button">Login</button>
                        <a className="switch-link" onClick={() => props.changeTab()}>Registration</a>
                    </form>
                </div>
            )}
        </div>
    );
}

export default LoginModal;
