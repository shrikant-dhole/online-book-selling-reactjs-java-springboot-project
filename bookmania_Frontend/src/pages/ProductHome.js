import React,{useEffect, useState} from 'react'

import Card from '../components/Card';
import Bdata from '../Category/Bdata';
import ProductHomecsss from "./ProductHome.css";
import { useParams } from 'react-router-dom';
 

const  ProductHome = () => {
  const [allBooks,setallBooks]=useState()
  const  [category,setCategory]=useState("null")
  // const {category}=useParams()
useEffect(function name(params) {
  console.log(category,"<<<<category")
  // alert("called")
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };
  if(category=="null" ){
    fetch("http://localhost:8087/api/bookshop/admin/getallbooks", requestOptions)
    .then(response => response.text())
    .then(result => {console.log(result,"<<<allbooks")
    setallBooks(JSON.parse(result))
  })
    .catch(error => console.log('error', error));
  }
 
  
},[category])
const filterB=(id)=>{
  setallBooks(allBooks.filter(item=>item.category.catid==id))
}
useEffect(()=>{
  if(category !="null"){
    changeCAtegory()
  }
},[category])
const changeCAtegory=async()=>{

  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  
  let raw = JSON.stringify({
    "userEmail": "chetanbadgujar1203@gmail.com",
    "password": "chetan@1"
  });
  
  let requestOptions = {
    method: 'GET',
    headers: myHeaders,
    // body: raw,
    redirect: 'follow'
  };
  
  fetch("http://localhost:8087/api/bookshop/user/getproductsbycategory/"+category, requestOptions)
    .then(response => response.text())
    .then(result => {console.log(result,"<<<productsby all bools")
      setallBooks(JSON.parse(result))
    })
    .catch(error => console.log('error', error));
}
  function Ncard (val){
    console.log(val);
    return(
    <Card
        key={val.key}
        src="/images/harrypotter.jpg"
        sname={val.bookname}
        author={val.author}
        price={val.price}
        prodId={val.prodId}
        />);
      }


  return (
<div className='container-fluid main-div'>
 <div style={{width:"100%",display:"flex",justifyContent:"center"}}>
  <div style={{width:"300px",}}>
  <select
style={{width:"100%",padding:"10px",borderRadius:"10px",margin:"10px 0px"}}
onChange={(e)=>{
console.log(e.target.value,"<<<changedvalue")
setCategory(e.target.value)
// filterB(e.target.value)
}}>
  <option value="null">All</option>
  <option value="3">Educational</option>
  <option value="4">Literature</option>
  <option value="1">Fiction</option>
  <option value="2">History</option>
</select>
  </div>


 </div>
    <div className='card-data'>
      
        {allBooks?.map(Ncard)}
       
    </div>
    </div>
  )
}

export default ProductHome