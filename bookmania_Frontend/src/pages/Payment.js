import React, { Component } from 'react';


class Payment extends Component {


    submit=()=>{
        alert("payment recieved")
        this.props.history.push("/purchase");
    }

    cancel=()=>{
        this.props.history.push("/cart");
    }

    render() {
        return (
            
                <div className="container">
                    <div>
                        <div>
                            <form required> 
                                    <br/><br/>
                                    <div>
                                        <label>Card Holder's Name</label>
                                        <div>
                                            <input type="text" pattern="\w+ \w+.*" required />
                                        </div>
                                    </div>

                                    <div>
                                        <label>Card Number</label>
                                        <div>
                                            <div>
                                                <div>
                                                    <input type="text"  maxLength="4" pattern="\d{4}" placeholder="First four digits" required />
                                                </div>
                                                <div >
                                                    <input type="text" maxLength="4" pattern="\d{4}" placeholder="Second four digits" required />
                                                </div>
                                                <div>
                                                    <input type="text" maxLength="4" pattern="\d{4}" placeholder="Third four digits" required />
                                                </div>
                                                <div>
                                                    <input type="text"  maxLength="4" pattern="\d{4}" placeholder="Fourth four digits" required />
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div>
                                        <label>Card Expiry Date</label>
                                        <div>
                                            <div>
                                                <div>
                                                    <select>
                                                        <option>January</option>
                                                        <option>February</option>
                                                        <option>March</option>
                                                        <option>April</option>
                                                        <option>May</option>
                                                        <option>June</option>
                                                        <option>July</option>
                                                        <option>August</option>
                                                        <option>September</option>
                                                        <option>October</option>
                                                        <option>November</option>
                                                        <option>December</option>
                                                    </select>
                                                </div>
                                                <div>
                                                    <select>
                                                        <option>2013</option>
                                                        <option>2014</option>
                                                        <option>2015</option>
                                                        <option>2016</option>
                                                        <option>2017</option>
                                                        <option>2018</option>
                                                        <option>2019</option>
                                                        <option>2020</option>    
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div>
                                        <label>Card CVV</label>
                                        <div>
                                            <div>
                                                <div>
                                                    <input type="password"  maxLength="3" pattern="\d{3}" placeholder="cvv" required />
                                                </div>
                                                <div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div>
                                    <br/>
                                    <button className="btn btn-info bg-info"><a style={{textDecorationLine:"none",color:"black"}} onClick={this.submit} >Submit</a></button>
                                    <button className="btn btn-info bg-danger"><a style={{textDecorationLine:"none",color:"black"}}  onClick={this.cancel}>Cancel</a></button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
                
        );
    }
}

export default Payment;