import React from 'react'
import './About.css';
import ReactDOM from "react-dom";
import image from "./images/BookLib.jpg";
import red from'./images/Red.jpg';
import shrikant from'./images/Shrikant.jpg';
import Sayali from'./images/Sayali.jpg';  
import pink from'./images/Pink.jpg';
import Ashutosh from'./images/Ashutosh.jpg';



 function About() {
  return (
    <section>
    <section id ="Head">
     <div className = "row">
       <div className = "ContentCol col-md-6">
         <h2>About Us</h2><br/>
         <div className ="AboutUsContent">
          <h3>“Read and read again until flies become bookworms”</h3>
            <h4>-BookMania</h4>
         <p>We offer huge collection of books in diverse category of Fiction, Non-fiction, Biographies, History, Religions, Self -Help, Children. Besides to this, we also offer a large collection of E-Books at very fair pricing.</p>
         <p>We attempt to extend the customer satisfaction by catering easy user-friendly search engine, quick and user-friendly payment options and quicker delivery systems. Upside to all of this, we are disposed to provide exciting offers and pleasant discounts on our books.</p>
         <p>As well, we humbly invite all the sellers around the country to partner with us. We will surely provide you the platform for many sparkling domains and grow the “BookMania” family.We would like to thank you for shopping with us. Upside to all of this, we are disposed to provide exciting offers and pleasant discounts on our books.“email-id” helping us to improvise for the reader satisfaction</p>
       </div>
     </div>
   
       <div className = "col-md-6">
         <img src = {image} className = "Img1" alt = "About Us"></img>
       </div>
     </div>
   </section>
   
   <section className = "container-fluid p-5 my-5 bg-dark text-white section-container" id = "Team">
   <h2>Our Team</h2><br/>
   <div className = "row">
      <div className = "col-sm-4"> 
         <img className = "image" src = {red}></img>
         <br></br><i> Chetan Badgujar </i>
         <p><a className ="icon" href = "https://www.linkedin.com/in/chetan-badgujar-b9a65615a"><i class="fa-brands fa-linkedin"></i></a></p>
      </div> 
      <div className = "col-sm-4"> 
         <img className = "image"src = {shrikant}></img>
         <br></br><i> Shrikant Dhole </i>
         <p><a className ="icon" href ="https://www.linkedin.com/in/shrikant-dhole-042446197/"><i class="fa-brands fa-linkedin"></i></a></p>
     </div> 
     <div className = "col-sm-4"> 
         <img className = "image"src = {Sayali}></img>
         <br></br><i> Sayali Palande </i>
         <p><a className ="icon" href = "https://www.linkedin.com/in/sayali-palande-4360a61a9/"><i class="fa-brands fa-linkedin"></i></a></p>
     </div>
   </div>
   
    <div className = "row">
     <div className = "Ashu col-sm">
       <img className = "image" src = {Ashutosh}></img>
       <br></br><i>Ashutosh Pansari</i>
       <p><a className ="icon" href="https://www.linkedin.com/in/ashutosh-pansari-70335015b/"><i class="fa-brands fa-linkedin"></i></a></p>   
    </div> 
   
     <div className = "Shivani col-sm">
        <img className = "image" src = {pink}></img>
       <br></br><i>Shivani Bopanwar </i>
       <p><a className ="icon" href="https://www.linkedin.com/in/shivani-bopanwar-ba488a217/ "><i class="fa-brands fa-linkedin" size ={'xl'}></i></a></p>
     </div> 
     </div>
     </section>
   
   </section>
  )
}
export default About;