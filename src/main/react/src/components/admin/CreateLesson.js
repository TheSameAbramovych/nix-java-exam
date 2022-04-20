import React, {useEffect, useState} from "react";
import {NavContext} from "../../context/navState";
import config from "../../config.json";
import TokenService from "../../service/TokenService";

const CreateLesson = () => {
    const [lesson, setLesson] = useState({});


    function setLesson() {
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer " + TokenService.getToken());

        const requestOptions = {
            method: "SET",
            headers: myHeaders,
            data: "follow",
        };

        fetch(config.SERVER_URL + "/lesson", requestOptions)
            .then((response) => response.json())
            .then((response) => {
                console.log(response)
                setLesson(response)
            })
        return lesson;


    }
}
