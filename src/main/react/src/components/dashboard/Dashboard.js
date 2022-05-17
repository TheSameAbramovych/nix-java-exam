import React from "react";
import "./Dashboard.css";
import Calendar from 'react-awesome-calendar';
import DashboardService from "../../service/DashboardService";


function getColor() {
    let i = 0
    let colors = ['#083761', '#14A98D', '#E0C646'];
    return () => {
        i = i === 3 ? 0 : i
        return colors[i++]
    }
}

class Dashboard extends React.Component {

    constructor(props) {
        super(props);

        this.date = new Date()
        this.calData = {
            mode: 'dailyMode', day: this.date.getDate(), year: this.date.getFullYear(), month: this.date.getMonth()
        }
        this.calendar = React.createRef()
        this.state = {dashboard: {}, lessons: []};

        DashboardService.dashboard((dashboard) => {
            console.log(dashboard)
            let color = getColor()
            // let offset = date.getTimezoneOffset()*60*60*1000;
            let offset = - this.date.getTimezoneOffset()*60*1000;
            var lessons = dashboard.lessons.map((lesson) => {
                let from = new Date(lesson.time );
                let to = new Date((lesson.time)  + 2700000);
                let time = from.getHours() + ":" + (from.getMinutes() === 0 ? "00" : from.getMinutes());
                return {
                    id: lesson.id,
                    color: color(),
                    from: from.toISOString(),
                    to: to.toISOString(),
                    title: lesson.subject.name + ": " + lesson.teacher.firstName + " " + lesson.teacher.lastName + " " + time
                }
            })
            this.setState({dashboard: dashboard, lessons: lessons});
        })
    }

    componentDidMount() {
        this.calendar.current.updater.enqueueSetState(this.calendar.current, this.calData, (e) => {
        })
    }

    componentDidUpdate() {
        Array.from(document.getElementsByClassName("dayEvent")).forEach((e) => {
            e.style.top = "calc(" + e.style.top + " - 280px - " + (this.date.getTimezoneOffset()/60) * 40 +"px)"
        })
    }

    render() {
        const header = (props) => {
            let date = new Date();
            return <div><h1>{date.toDateString()}</h1> </div>
        }

        return (<div className={'wrapper'}>
            <div className={'content'}>
                <div className={'dashboard-grid'}>
                    <div className={'profile'}>
                        <h2>First Name: {this.state.dashboard.profile?.firstName}</h2>
                        <h2>Last Name: {this.state.dashboard.profile?.lastName}</h2>
                        <h2>Email: {this.state.dashboard.profile?.email}</h2>
                        <h2>Birth
                            Day: {(this.state.dashboard.profile?.birthDate === undefined ? "" : new Date(this.state.dashboard.profile.birthDate).toDateString())}</h2>
                    </div>
                    <div className={'next-event'}>
                        <h2>Next-event</h2>
                    </div>
                    <div className={'today'}>
                        <Calendar ref={this.calendar} events={this.state.lessons} header={header}/>
                    </div>
                </div>
            </div>
        </div>);
    }
}

export default Dashboard;
