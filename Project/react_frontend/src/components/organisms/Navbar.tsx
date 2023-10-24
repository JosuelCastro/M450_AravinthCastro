import React, { useContext } from "react";
import { Link } from "react-router-dom";
import ActiveUserContext from "../../Contexts/ActiveUserContext";
import logo from '../../logo1.png';
import {Button} from "@mui/material"; // Import the logo image

const Navbar = () => {
    const { user, logout } = useContext(ActiveUserContext);

    return (
        <nav className="navbar">
            <ul className="navbar-nav">
                <li className="nav-item">
                    <img src={logo} alt="Logo" className="logo-image" />
                </li>
                <li className="nav-item">
                    <Link to="/" className="nav-link">
                        Home
                    </Link>
                </li>
                <li className="nav-item">
                    <Link to="/userprofile" className="nav-link">
                        Profile
                    </Link>
                </li>
                <li className="nav-item">
                    <Link to="/users" className="nav-link">
                        Admin
                    </Link>
                </li>
                <li className="nav-item right-most">
                    {user ? (
                        <button style={{backgroundColor:"transparent"}} className="nav-link" onClick={logout}>
                            Logout
                        </button>
                    ) : (
                        <Link to="/user/login" className="nav-link">
                            Login
                        </Link>
                    )}
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;
