import React, { useState } from "react";

import UserCartcss from "./UserCart.css";
import The_Hobbit from "../components/images/The_Hobbit.jpg";
import { useEffect } from "react";
import axios from "axios";
import { TroubleshootSharp } from "@mui/icons-material";

const UserCart = () => {
  const [cartData, setCartData] = useState([]);
  
  const totalAmount=(arr)=>{
let total=0
arr.map(item=>{
  total=+total + +item?.product.price
})
return total
  }
const getCartData=async()=>{
  const myuserobj = localStorage.getItem("bookmaniauser");
  console.log(myuserobj,"<<<myuserobj")
  
  const user = JSON.parse(myuserobj);
  // alert("cart data fetch")
  const {data}= await axios.get(`http://localhost:8087/api/bookshop/customer/${user.id}/cart`)
  console.log(data,"<<<apicartdata") 
  if(data.length){

    setCartData([data[0]])
  }
}
useEffect(
  ()=>{
    getCartData()
  },[]
)

const buyProduct=(id)=>{
  var axios = require('axios');
var data = '';
const myuserobj = localStorage.getItem("bookmaniauser");
console.log(myuserobj,"<<<myuserobj")

const user = JSON.parse(myuserobj);
var config = {
  method: 'post',
  url: `http://localhost:8087/api/bookshop/customer/${user.id}/buy/${id}`,
  headers: { },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
  alert(JSON.stringify(response.data) )
  window.location.reload(true)
})
.catch(function (error) {
  console.log(error);
});

}
const removeProduct=(id)=>{
  const myuserobj = localStorage.getItem("bookmaniauser");
console.log(myuserobj,"<<<myuserobj")

const user = JSON.parse(myuserobj);
  var axios = require('axios');
var data = JSON.stringify({
  "user": "2",
  "product": "38"
});

var config = {
  method: 'delete',
  url: `http://localhost:8087/api/bookshop/customer/${user.id}/cart/${id}/deletefromcart`,
  headers: { 
    'Content-Type': 'application/json'
  },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
  alert(response.data)
  window.location.reload(true)
})
.catch(function (error) {
  console.log(error);
});

}
console.log(cartData,"<<<thisiscartData")
  return (<>
  <h1>My Cart</h1>
  {cartData.length ==0 && <div style={{width:"100%",textAlign:"center",fontWeight:"bold",fontSize:"2rem"}}>Cart is Empty</div>}
 {cartData.length !=[] && cartData?.map(pro=>{
  const item=pro?.product
  return <div className="container">
  <table className="table cart-table">
    <tr>
      <th className="img-col">Image</th>
      <th className="name--col">Name</th>
      <th className="description-col">Description</th>
      <th className="price-col">Price .INR</th>
    </tr>
    <tr>
      <td name="image">
        <img
          src={item?.image}
          alt="Product-Image"
          className="produuct-img"
        />
      </td>
      <td name="name">{item?.bookname}</td>
      <td>
        <p name="description">
          {item?.desc}
        </p>
      </td>
      <td name="price"> {item?.price}</td>
    </tr>
  </table>

  <button className="btn btn-primary" onClick={()=>removeProduct(item?.prodId)}>Remove Product </button>
 
 
</div>
 })}
 <div className="container">
 <div className="total-amt">
    {" "}
    <div className="buy-btn">
    <button className="btn btn-primary" onClick={()=>buyProduct(cartData[0]?.product?.prodId)}> Buy & Proceed to pay</button>
    <h3>
      Total Amount :
      <span className="total-price" name="total-price">
        {" "}
        {totalAmount(cartData)}
      </span>{" "}
    </h3>
  </div>
    
  </div>
 </div>
 
  </>
   
  );
};

export default UserCart;
