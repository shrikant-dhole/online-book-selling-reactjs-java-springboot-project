import React from "react";
import { Link } from "react-router-dom";
import Cardcss from "./Card.css";

import commonimage from "../images/commonbook.jpg"
function Card(props) {
  const addToCart=(prodId)=>{
    const myuserobj = localStorage.getItem("bookmaniauser");
    console.log(myuserobj,"<<<myuserobj")
    
    const user = JSON.parse(myuserobj);
    console.log(user,"<<<<thisisuser")
    var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  // alert(props.prodId)
  var raw = JSON.stringify({
    "user": "3",
    "product": "46"
  });
  
  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };
  
  fetch(`http://localhost:8087/api/bookshop/customer/${user.id}/addtocart/${props.prodId}`, requestOptions)
    .then(response => response.text())
    .then(result => {
      console.log(result)
      alert("Ïtem Added to Cart")
      // window.location.reload(true)
  
    })
    .catch(error => console.log('error', error));
  }
  const AddProduct = () => {
    const userData = localStorage.getItem("bookmaniauser");
    console.log(`${userData}`, "<<<<user Data");

    if (userData != null && userData != "null") {
      localStorage.setItem("bookmainacart", JSON.stringify(props));
      addToCart()
      // window.location.href = "/mycart";
    } else {
      localStorage.setItem("bookmainacart", JSON.stringify(props));
      window.location.href = "/";
    }
  };

  return (
    <div className="container-fluid" style={{width:"300px"}}>
      <div className="card ">
        {console.log(props.src)}
        {/* <img src={require("D:\Group-No-17\REACT JS\bookmania\bookmania\src"+props.src)} alt="image" className="card-img-top card-img"></img> */}
        <img src={commonimage}/>
        <div className="card_info">
          <span className="card-title">{props.sname}</span>
          <h3 className=""></h3>
          <span className="">{props.author}</span>
          <h3 className=""></h3>
          <span className="price">Price {props.price}</span>
          <h3 className=""></h3>
          <span className="">
            {/* <Link to={"/mycart"}> */}
              <button className="btn btn-primary button" onClick={AddProduct}>
                Add to Cart
              </button>
            {/* </Link> */}
          </span>
        </div>
      </div>
    </div>
  );
}
export default Card;
