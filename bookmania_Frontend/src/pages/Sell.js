
import "./Sell.css";
import React, { useState, useContext,useEffect } from "react";
//import { ToastContainer, toast } from "react-toastify";
import { Link, useNavigate } from "react-router-dom";
import { UserContext } from "../App";
import CustomerService from "../services/CustomerService";
//import { sellBook } from "../services/CustomerService";






const Sell = () => {


  const user=localStorage.getItem('user');
  const userobj=JSON.parse(user);
  const id =userobj.id;
  const { state, dispatch } = useContext(UserContext);
   console.log(id);

  const history = useNavigate();
  const [bookname, setBookname] = useState("");
  const [author, setAuthor] = useState("");
  const [category, setCategory] = useState("");
  const [price, setPrice] = useState("");
  const [image, setImage] = useState("");
  const [desc, setDesc] = useState("");
  const [available, setAvailable] = useState(true);
  const [seller, setSeller] =useState(id);
  
   
   
  const [errors, setErrors] = useState({});
  const [dataIsCorrect, setDataIsCorrect] = useState(false);
  const [dataAdded, setDataAdded] = useState('');

  const data = {bookname,author,category ,price,image,desc,available,seller}; 
  
  const addData = (e) => {
    e.preventDefault();
  
    
  console.log(data);

  if (bookname === "") {
   alert(" Book bookname field is requred!", {
      position: "top-center",
    });
  } else if (author === "") {
    alert(" Author name field is requred!", {
      position: "top-center",
    });
  }else if (price === " ") {
   alert(" Price field is requred!", {
      position: "top-center",
    });
  }
  else if (image === " ") {
    alert(" Book Images field is requred!", {
       position: "top-center",
     });
   }else if (desc === " ") {
    alert(" desc field is requred!", {
       position: "top-center",
     });
   } else {
     dispatch({ type: "user", payload: true }); 
     console.log("sending",data,id);
    if(dataIsCorrect === true){
      CustomerService.sellBook(data,id)
      .then(response => {
          console.log("Book added successfully", response.data);
          
          setDataAdded("Book added succesfully");
          history("/");
         
      })
      .catch(error => {
          console.log('Something went wrong', error);
          setDataAdded("Error While sending book");
      })
    } 

    
  

    
   }
  
  }
  useEffect(() => {
    if(Object.keys(errors).length === 0 && !dataIsCorrect){
        setDataIsCorrect(true)
    }
  }, [dataIsCorrect, errors]);


  return (
    <div className="container-fluid d-flex justify-content-center  mt-5 mb-5 ">
      <div className="border border-dark form-bg">
        <h1>Sell Your Book Here</h1>
        <form>
          <div className="form-group m-3">
          <label htmlFor="bookname">Bookname :</label>
          <input className="form-control" type={Text} name="bookname" onChange ={(e) => setBookname(e.target.value)} required />
          </div>
          <div className="form-group m-3">
          <label htmlFor="author">Author Name :</label>
          <input className="form-control" type={Text} name="author" onChange={(e) => setAuthor(e.target.value)} required></input>
          </div>
          <div className="form-group m-3">
          <label htmlFor="category">Book Category :</label>
          <select className="form-control" name="category" onChange={(e) => setCategory(e.target.value)}>
            <option selected name="select">Select</option>
            <option >Educational</option>
            <option>Literature</option>
            <option>fiction</option>
            <option>history</option>
    
          </select>
          </div>
          <div className="form-group m-3">
          <label htmlFor="price">Price :</label>
          <input
            className="form-control"
            type={Number}
            placeholder="In INR"
            name="price"
            onChange={(e) => setPrice(e.target.value)}
            required
          ></input>
          </div>
          <div className="form-group m-3">
          <label htmlfor="image">Book Images :</label>
          <input
            className="form-control"
            // type="file"
            id="exampleFormControlFile1"
            name="image"
            onChange={(e) => setImage(e.target.value)}
            required
          />
          </div>
          <div className="form-group m-3">
          <label htmlFor="desc">Book desc : </label>
          <textarea className="form-control" name="desc" onChange={(e) => setDesc(e.target.value)}
            required></textarea>
          </div>
          <input
            type="submit"
            value="Submit"
            class="btn btn-outline-success button "
            onClick={addData}
          />
          <input type="reset" value="Reset" class="btn btn-outline-secondary button" />
        </form>
      </div>
    </div>
  );
}
export default Sell;
