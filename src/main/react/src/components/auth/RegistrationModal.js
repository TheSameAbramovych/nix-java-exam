import React, {useContext, useRef, useState} from "react";
import {NavContext} from "../../context/navState";
import "./Auth.css";
import AuthService from "../../service/AuthService";
import Calendar from "react-calendar";
import 'react-calendar/dist/Calendar.css';

function RegistrationModal(props) {

    const {isRegisterOk} = useContext(NavContext);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [birthDate, setBirthDate] = useState(new Date());
    const [email, setEmail] = useState("");
    const [showCalendar, setShowCalendar] = useState(false);

    function submit(event) {
        const user = {
            login: login,
            password: password,
            firstName: firstName,
            lastName: lastName,
            email: email,
            birthDate: formatDate(new Date(birthDate.toUTCString()))
        };

        AuthService.registration(user, (user) => {
            props.changeTab();
        })
    }

    function padTo2Digits(num) {
        return num.toString().padStart(2, '0');
    }

    function formatDate(date) {
        return [
            date.getFullYear(),
            padTo2Digits(date.getMonth() + 1),
            padTo2Digits(date.getDate()),
        ].join('-');
    }


    return (
        <div>
            {!isRegisterOk && (
                <div className="modal">
                    <form className="registration-form" onSubmit={submit}>
                        <h3>Registration</h3>
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
                        <label htmlFor="firstName">First Name</label>
                        <input
                            id="firstName"
                            value={firstName}
                            onChange={(event) => {
                                setFirstName(event.target.value);
                            }}
                        />
                        <label htmlFor="lastName">Last Name</label>
                        <input
                            id="lastName"
                            value={lastName}
                            onChange={(event) => {
                                setLastName(event.target.value);
                            }}
                        />
                        <label htmlFor="email">Email</label>
                        <input
                            id="email"
                            value={email}
                            onChange={(event) => {
                                setEmail(event.target.value);
                            }}
                        />
                        <label htmlFor="birthDate">Birth Date</label>
                            <Calendar className={showCalendar ? 'calendar-style' : 'calendar-disable'}
                                      value={birthDate}
                                      onChange={(event) => {
                                          setBirthDate(event);
                                      }}
                            />
                        <input
                            readOnly={true}
                            id="birthDate"
                            value={formatDate(birthDate)}
                            onClick={(event) =>{
                                setShowCalendar(!showCalendar);
                            }}
                        />
                        <button className="login-button">Register</button>
                        <a className="switch-link" onClick={() => props.changeTab()}>Login</a>
                    </form>
                </div>
            )}
        </div>
    );
}

export default RegistrationModal;
