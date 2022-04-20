const getToken = () => {
    return localStorage.getItem("token");
}

const removeToken = () => {
    return localStorage.removeItem("token");
}

const updateToken = (token) => {
    localStorage.setItem("token", token);
}

const TokenService = {
    getToken, updateToken, removeToken
}

export default TokenService


