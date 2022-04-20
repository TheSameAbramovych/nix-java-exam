import React, {useContext, useRef} from 'react';
import styled, {css} from 'styled-components';
import useOnClickOutside from '../../hooks/onClickOutside';
import {NavContext} from '../../context/navState';
import HamburgerButton from './HamburgerButton';
import {SideMenu} from './SideMenu';
import Logout from "../auth/Logout";

const Navbar = styled.div`
  height: 50px !important;
  display: flex;
  left: 0;
  right: 0;
  box-sizing: border-box;
  outline: current color none medium;
  max-width: 100%;
  margin: 0px;
  align-items: center;
//   background: #000000 none repeat scroll 0% 0%;
  background-color: rgba(0,0,0,0.7); 

  color: rgb(248, 248, 248);
  min-width: 0px;
  min-height: 0px;
  flex-direction: row;
  justify-content: flex-start;
  padding: 3px 3px;
  box-shadow: rgba(0, 0, 0, 0.2) 0px 8px 16px;
  z-index: 500;
  ${(props) =>
    props.active &&
    css`
      position: absolute;
      backdrop-filter: blur(30px);
    `}
`;

const MainMenu = () => {
    const node = useRef();
    const {isLogin, isMenuOpen, toggleMenuMode} = useContext(NavContext);
    useOnClickOutside(node, () => {
        // Only if menu is open
        if (isMenuOpen) {
            toggleMenuMode();
        }
    });

    return (
        <header ref={node}>
            <Navbar active={isLogin()}>
                <HamburgerButton/>
                <h1>Simple School</h1>
                <Logout/>
            </Navbar>
            <SideMenu/>
        </header>
    );
};

export default MainMenu;