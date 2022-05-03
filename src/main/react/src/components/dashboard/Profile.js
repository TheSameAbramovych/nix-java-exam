import React, {useContext} from "react";


function MainContent(props) {

    return (
        <div className={'profile'}>
            <h2>Login {props.profile.dashboard?.login}</h2>
            <h2>First Name {props.profile.dashboard?.firstName}</h2>
            <h2>Last Name {props.profile.dashboard?.lastName}</h2>
            <h2>Birth Day {(props.profile.dashboard?.birthDate === undefined ? "" :
                new Date(props.profile.dashboard.birthDate).toDateString())}</h2>
        </div>
    )
}

export default MainContent;
