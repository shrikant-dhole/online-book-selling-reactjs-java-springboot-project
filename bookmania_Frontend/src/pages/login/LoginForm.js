import React, { useEffect, useState } from 'react'
import useForm from './UseForm';
import { Link } from 'react-router-dom';
import login from "./Login.css"
// import { login } from '../../services/UserService';

const LoginForm = ({ submitForm }) => {
const [loginState,setLoginState]=useState(false)
    const {handleChange,handleFormSubmit,values,errors,dataAdded,isLoggedIn} = useForm(submitForm);

useEffect(()=>{
  console.log(isLoggedIn,"<<isLoggedin data")
  setLoginState(localStorage.getItem("bookmaniauser"))
},[isLoggedIn])
console.log(`${loginState}`,"<<<login state")
  return (
<>
{(()=>{
  if(loginState ==null || loginState =="null" || loginState==false){
     <h3 class="alert alartbox alert-primary" role="alert">{dataAdded}</h3>
   return <div className="container-fluid d-flex justify-content-center  mt-5 mb-5 form">
          <div className="border border-dark form-container ">
            <h1 className="mt-2">Login</h1>
            <div>
              <div class="form-group m-3">
                <label htmlfor="userEmail">Email :</label>
                <input
                  type="userEmail"
                  class="form-control"
                  name="userEmail"
                  value={values.userEmail}
                  onChange={handleChange}
                />
                 {errors.userEmail && <p className="error">{errors.userEmail}</p>}
              </div>
              <div class="form-group m-3">
                <label htmlfor="password">Password :</label>
                <input
                  type="password"
                  class="form-control"
                  name="password"
                  value={values.password}
                  onChange={handleChange}
                />
                {errors.password && <p className="error">{errors.password}</p>}
              </div>
              <div className="form-group login-button">
                <button
                  // type="submit"
                  class="btn btn-outline-success "
                  onClick={handleFormSubmit}
                >
                  {" "}
                  Login
                </button>
                <br />
              </div>
              <div class="form-group m-3 text-center">
                <span className="text-danger" id="invalid-data">
                  {/* Invalid Email or Password. */}
                  {dataAdded}
                </span>
                <br />
                <span className="forgot-pass text-info">
                  <Link className="nav-link" to="/forgotpass">
                    Forgot password ?
                  </Link>
                </span>
                <span className="new-acc">
                New User? Register here{" "}
                  <Link
                    className="nav-link new-acc btn-outline-success my-2 my-sm-0"
                    to="/registration"
                  >
                    Register Now
                  </Link>
                </span>
              </div>
            </div>
          </div>
        </div>
  }
})()}


</>

  )

}

export default LoginForm