import Api from "./Api";

const login = (login, password, update) => {
    Api.post("/token", {
            login,
            password
        })
        .then(response => {
            if (response.data.token) {
                update(response.data.token);
            }
        });
}

const registration = (user, update) => {
    Api.post("/register", user, )
        .then(response => {
            if (response.data) {
                update(response.data);
            }
        });
}

const AuthService = {
    login, registration
}

export default AuthService