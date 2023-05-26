import React, { useState ,useEffect } from "react";
import "./Registration.css";
import { ToastContainer, toast } from "react-toastify";
import { Link, useNavigate } from "react-router-dom";
import { createAccount } from "../services/CustomerService";
import CustomerService from "../services/CustomerService";
import Validation from "./Validation";


const Registration = () => {
  const navigate=useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [plotNumber, setPlotNumber] = useState("");
  const [landmark, setLandmark] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [pincode, setPincode] = useState("");
  const [role, setRole] = useState("CUSTOMER");

  const [errors, setErrors] = useState({});
  const [dataIsCorrect, setDataIsCorrect] = useState(false);
  const [dataAdded, setDataAdded] = useState('');

  

  const address = { plotNumber, landmark, city, state, pincode };
  const user = {firstName,lastName,contactNo,email,password,role,address};

  const handleFormSubmit = (event) => {
    event.preventDefault();
  
    setErrors(Validation(user));
   
    console.log("sending",user);
    if(dataIsCorrect === true){
      CustomerService.createAccount(user)
      .then(response => {
          console.log("User added successfully", response.data);
         
          setDataAdded("Registration Successful");
          navigate("/login");
         
      })
      .catch(error => {
          console.log('Something went wrong', error);
          setDataAdded("Error While Registration");
      })
    } 
};
useEffect(() => {
  if(Object.keys(errors).length === 0 && !dataIsCorrect){
      setDataIsCorrect(true)
  }
}, [dataIsCorrect, errors]);

  return (
    <div className="form">
    <div className="container-fluid d-flex justify-content-center  mt-5 mb-5 ">
      <div className="border border-dark form-bg">
        <h1>Register Here</h1>
        <form>
          <div className="form-group m-3  ">
            <label htmlFor="firstName">Name :</label>
            <div class="form-row">
              <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="firstName"
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                  
                />
                {errors.firstName &&  <p className="error">{errors.firstName}</p>}
              </div>
              <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="lastName"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                />
                {errors.lastName && <p className="error">{errors.lastName}</p>}
              </div>
            </div>
          </div>
          <div className="form-group m-3  ">
            <label htmlFor="address">Address :</label>
            <div class="form-row">
              <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="plotNumber"
                  value={plotNumber}
                  onChange={(e) => setPlotNumber(e.target.value)}
                  placeholder="Plot No"
                />
                {errors.plotNumber && <p className="error">{errors.plotNumber}</p>}
              </div>
              <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="landmark"
                  value={landmark}
                  onChange={(e) => setLandmark(e.target.value)}
                  placeholder="Landmark"
                />
                {errors.landmark && <p className="error">{errors.landmark}</p>}
              </div>
            </div>
            <br/>
            <div class="form-row">  
            <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="city"
                  value={city}
                  onChange={(e) => setCity(e.target.value)}
                  placeholder="City"
                />
                {errors.city && <p className="error">{errors.city}</p>}
              </div>
              <div class="col">
                <input
                  type="text"
                  class="form-control"
                  name="state"
                  value={state}
                  onChange={(e) => setState(e.target.value)}
                  placeholder="State"
                />
                {errors.state && <p className="error">{errors.state}</p>}
              </div>
              <div class="col">
                <input
                  type="number"
                  class="form-control"
                  name="pincode"
                  value={pincode}
                  onChange={(e) => setPincode(e.target.value)}
                  placeholder="Pincode"
                />
                {errors.pincode && <p className="error">{errors.pincode}</p>}
              </div>
              
              </div>
            </div>
          <div class="form-group m-3">
            <label htmlfor="contactNo">Mobile No :</label>
            <input
              type="number"
              class="form-control"
              name="contactNo"
              value={contactNo}
              onChange={(e) => setContactNo(e.target.value)}
            />
            {errors.contactNo && (
              <p className="error">{errors.contactNo}</p>
            )}
         
          </div>
          <div class="form-group m-3">
            <label htmlfor="email">Email :</label>
            <input
              type="email"
              class="form-control"
              name="email"
              value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {errors.email && <p className="error">{errors.email}</p>}
           
          </div>
          <div class="form-group m-3">
            <label htmlfor="password">Password :</label>
            <input
              type="password"
              class="form-control"
              name="password"
              value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
                {errors.password && <p className="error">{errors.password}</p>}
          </div>
         
          <div class="form-group form-check m-3">
            <input type="checkbox" class="form-check-input" required />
            <span class="form-text">I accept all terms and conditions.</span>
          </div>
          <button
            type="submit"
            class="btn btn-outline-success button"
            onClick={handleFormSubmit}
          >Register</button>
          <button type="reset" class="btn btn-outline-secondary button">
            Reset
          </button>
        </form>
      </div>
    </div>
    </div>
  );
};
export default Registration;