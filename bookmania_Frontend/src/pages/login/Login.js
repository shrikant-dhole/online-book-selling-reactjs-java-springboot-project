import React from 'react'
import { useState } from 'react'
import LoginForm from './LoginForm'
import useForm from './UseForm';
// import {isLoggedIn} from "./UseForm"

const Login = () => {
    const [formIsSubmitted, setFormIsSubmitted] = useState(false);
    const {isLoggedIn} =useForm()
console.log(isLoggedIn,"<<<isloggedi")
    const submitForm = () =>{
      // setFormIsSubmitted(true);
    };
  
    return (
      <div>
        {(!isLoggedIn)?
          <LoginForm submitForm={submitForm}/>:""
        }
      </div>
    )
}

export default Login