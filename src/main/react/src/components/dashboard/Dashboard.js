import React from "react";
import "./Dashboard.css";
import Calendar from 'react-awesome-calendar';
import DashboardService from "../../service/DashboardService";
import randomColor from "randomcolor";


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

    render() {
        const header = (props) => {
            return <div><h1></h1></div>
        }

        return (
            <div className={'wrapper'}>
                <div className={'content'}>
                    <div className={'dashboard-grid'}>
                        <div className={'profile'}>
                            <h2>Login {this.state.dashboard?.login}</h2>
                            <h2>First Name {this.state.dashboard?.firstName}</h2>
                            <h2>Last Name {this.state.dashboard?.lastName}</h2>
                            <h2>Birth Day {(this.state.dashboard?.birthDate === undefined ? "" :
                                new Date(this.state.dashboard.birthDate).toDateString())}</h2>
                        </div>
                        <div className={'next-event'}>
                            <h2>Next-event</h2>
                        </div>
                        <div className={'today'}>
                            {/*<button onClick={click}>Teeeeest</button>*/}
                            <Calendar ref={this.calendar} events={this.state.lessons} header={header}/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Dashboard;
