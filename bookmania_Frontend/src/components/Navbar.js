import React, { useEffect, useState } from "react";
import "./Navbar.css";
import logo from "./logo.jpg";
import Greet from "../pages/Greet";

import { Link } from "react-router-dom";



const Navbar = () => {
  const myuserobj = localStorage.getItem("bookmaniauser");
  console.log(myuserobj,"<<<myuserobj")
  const user = JSON.parse(myuserobj);

  const [userobj, setUserobj] = useState(false);

  useEffect(() => {
    const loggedIn = localStorage.getItem("bookmaniauser");
    if (loggedIn !=null || loggedIn != "null") {
      setUserobj(true);
    }
  }, []);
console.log(localStorage.getItem("bookmaniauser"))
  const logout = () => {
    localStorage.setItem("bookmaniauser",null);
    window.location.href="/"
        // setUserobj(false);
  };


  return (
    <div>
    <div className="header">
      <nav className="navbar navbar-expand-lg navbar-light">
        <img src={logo} className="logo " alt="logo" />
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
       
        <div className="collapse navbar-collapse ml-5 ">
        
   
   <ul className="navbar-nav mr-auto">
      <li className="nav-item active">
        <Link className="nav-link" to="/">
          Home
        </Link>{" "}
        <span className="sr-only">(current)</span>
      </li>
      <li className="nav-item  link ml-2">
        <Link
          classNameName="Link nav-item"
          to="/about"
          style={{ color: "rgb(90, 90, 90)", textDecoration: "none" }}
        >
          About Us
        </Link>
      </li>
      <li className="nav-item  link ml-2">
      {userobj ? ( <Link
          className="Link nav-item"
          to="/sell"
          style={{ color: "rgb(90, 90, 90)", textDecoration: "none" }}
        >
         Sell
        </Link>):
        ("")}
      </li>
      
        
      <li className="nav-item ml-2 ">
      <Link className="nav-link" to="/mycart">
        <i class="fa-sharp fa-solid fa-cart-shopping"></i> Cart
        </Link>
        
      </li>
      
    </ul>
    </div>
    <form className="form-inline mr-5 ">
      <input
        className="form-control ml-0 "
        type="search"
        placeholder="Search"
        aria-label="Search"
      />
      <button className="btn btn-outline-info mr-5 " type="submit">
        Search
      </button>
      <div className="form-group login-buton">
      
                {myuserobj ==null ||myuserobj =="null" ? (
                  <Link className="nav-link" to="/registration">
                    <button type="submit" className="btn btn-outline-primary ">
                  {" "}
                 Register
                </button>
                  </Link>
                ) : (
                  ""
                )}
                {myuserobj ==null ||myuserobj =="null" ? (
                <Link className="nav-link" to="/login">
                <button type="submit" className="btn btn-outline-primary ">
                  {" "}
                  Login
                </button>
              </Link>
                ) : (
                  ""
                )}
                {myuserobj !=null &&myuserobj!="null" ? (
                  <div onClick={logout}>
                  {/* <Link as={Link}  > */}
                   <i class="fa-solid fa-arrow-right-from-bracket"></i>Logout
                  {/* </Link> */}
                    </div>
                ) : (
                  ""
                )}
      </div>
      
    </form>
    </nav>
        </div>
      
    </div>
  );
}

export default Navbar;
