import React, {createContext, useState} from "react";
import PropTypes from "prop-types";
import TokenService from "../service/TokenService";

export const NavContext = createContext();

const NavState = ({children}) => {
    const [isMenuOpen, toggleMenu] = useState(false);
    const [activeView, changeActiveView] = useState('dashboard');
    const [token, setToken] = useState('');

    function toggleMenuMode() {
        console.log("isMenuOpen:" + !isMenuOpen)
        toggleMenu(!isMenuOpen);
    }

    function isLogin() {
        return TokenService.getToken() !== null;
    }

    function updateToken(token) {
        if (token === null){
            TokenService.removeToken()
        } else {
            TokenService.updateToken(token)
        }
        setToken(token)
    }

    return (
        <NavContext.Provider
            value={{isLogin, updateToken, activeView, changeActiveView, isMenuOpen, toggleMenuMode}}>
            {children}
        </NavContext.Provider>
    );
};

NavState.propTypes = {
    children: PropTypes.node.isRequired,
};

export default NavState;
