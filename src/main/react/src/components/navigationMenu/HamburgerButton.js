import React, {useContext} from 'react';
import styled from 'styled-components';
import {NavContext} from '../../context/navState';

const MenuButton = styled.button`
  display: block;
  transform-origin: 16px 11px;
  float: left;
  margin-right: 22px;
  margin-left: 10px;
  outline: unset;
  border: 0;
  padding: 0px;
  background: none;
  span:nth-of-type(1) {
    margin-top: 0px;
  }
    span {
    transition: all 0.3s cubic-bezier(0.645, 0.045, 0.355, 1);
  }
  :focus {
    border: medium none rgb(111, 255, 176);
    outline: unset;
  }
  :hover {
    span:nth-of-type(1) {
      width: 33px;
    }
    span:nth-of-type(2) {
      width: 33px;
    }
    span:nth-of-type(3) {
      width: 33px;
    }
  }
  &.active {
    span:nth-of-type(1) {
      transform: rotate(45deg) translate(0px, 11px);
      width: 35px;
    }
    span:nth-of-type(2) {
      opacity: 0;
      pointer-events: none;
    }
    span:nth-of-type(3) {
      transform: rotate(-45deg) translate(0px, -11px);
      width: 35px;
    }
  }
`;

const Bar = styled.span`
  display: block;
  width: 30px;
  height: 3px;
  margin-top: 5px;
  background-color: #fff;
`;

const HamburgerButton = () => {
    const {isMenuOpen, toggleMenuMode} = useContext(NavContext);

    const clickHandler = () => {
        toggleMenuMode();
    };

    return (
        <MenuButton
            className={isMenuOpen ? 'active' : ''}
            aria-label="Открыть главное меню"
            onClick={clickHandler}
        >
            <Bar/>
            <Bar/>
            <Bar/>
        </MenuButton>
    );
};

export default HamburgerButton;