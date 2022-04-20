import React, {useEffect, useState} from "react";
import {NavContext} from "../../context/navState";
import "./Dashboard.css";
import config from "../../config.json";
import TokenService from "../../service/TokenService";

const Dashboard = () => {
    const [dashboard, setDashboard] = useState({});

    function getDashboard() {
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer " + TokenService.getToken());

        const requestOptions = {
            method: "GET",
            headers: myHeaders,
            data: "follow",
        };

        fetch(config.SERVER_URL + "/dashboard", requestOptions)
            .then((response) => response.json())
            .then((response) => {
                console.log(response)
                setDashboard(response)
            })
        return dashboard;

    }

    useEffect(() => {
        getDashboard()
    }, [])

    return (
        <div className={'wrapper'}>
            <div className={'content'}>
                <div className={'dashboard-grid'}>
                    <div className={'profile'}>
                        <h2>Login {dashboard?.login}</h2>
                        <h2>First Name {dashboard?.firstName}</h2>
                        <h2>Last Name {dashboard?.lastName}</h2>
                        <h2>Birth Day {(dashboard?.birthDate === undefined ? "" :
                            new Date(dashboard.birthDate).toDateString())}</h2>
                    </div>
                    <div className={'next-event'}>
                        <h2>Next-event</h2>
                    </div>
                    <div className={'today'}>
                        <h2>Today</h2>
                        {/*https://github.com/jquense/react-big-calendar*/}
                    </div>
                </div>
            </div>
        </div>
    );

}

export default Dashboard;
