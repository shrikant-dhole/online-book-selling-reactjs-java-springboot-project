import React from 'react'
import "./Footer.css";
 function Footer() {
  return (<div >
      
      
      <footer className="bg-dark text-center text-white">
    
  {/* <!-- Grid container --> */}
  <div className="container p-4 footer">
  Connect with us
    {/* <!-- Section: Social media --> */}
    <section className="mb-4">
        
      {/* <!-- Facebook --> */}
      <a className="btn btn-outline-light btn-floating m-1 " href="#!" role="button"
        ><i className="fab fa-facebook-f"></i
      ></a>

      {/* <!-- Twitter --> */}
      <a className="btn btn-outline-light btn-floating m-1 " href="#!" role="button"
        ><i className="fab fa-twitter"></i
      ></a>

      {/* <!-- Google --> */}
      <a className="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i className="fab fa-google"></i
      ></a>

      {/* <!-- Instagram --> */}
      <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i class="fab fa-instagram"></i
      ></a>

      {/* <!-- Linkedin --> */}
      <a className="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i className="fab fa-linkedin-in"></i
      ></a>
{/* 
      <!-- Github --> */}
      <a className="btn btn-outline-light btn-floating m-1" href="#!" role="button"
        ><i className="fab fa-github"></i
      ></a>

    </section>
    <div className="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4  ">
         
         <h6 className="text-uppercase fw-bold mb-4 ">Contact Us</h6>
         <p className="contact-info"><i className="fas fa-home me-3 "></i> AIT YCP, Nariman Point, Mumbai.</p>
         <p className="contact-info">
           <i className="fas fa-envelope me-3 "></i>
           info@bookmania.com
         </p>
         <p className="contact-info"><i className="fas fa-phone me-3 contact-info"></i> + 9975366147</p>
         
       </div>
       
    </div>
    </footer> 
      </div>

      
  );
}
export default Footer;