const Validation = (values) => {
    
    let errors = {};

    if(!values.firstName){
        errors.firstName = "First Name is Required."
    }

    if(!values.lastName){
        errors.lastName = "Last Name is Required."
    }

    if(!values.contactNumber){
        errors.contactNumber = "Contact Number is Required."
    }

    if(!values.userEmail){
        errors.userEmail = "Email is Required."
    }else if(!/\S+@\S+\.\S+/.test(values.userEmail)){
        errors.userEmail = "Email is invalid."
    }

    if(!values.password){
        errors.password = "Password is Required."
    }else if(values.password.length < 5){
        errors.password = "Password must be more then 5 charecters."
    }

    if(!values.address.plotNumber){
        errors.plotNumber = "Plot No. is Required."
    }

    if(!values.address.landmark){
        errors.landmark = "Landmark is Required."
    }

    if(!values.address.city){
        errors.city = "City is Required."
    }

    if(!values.address.state){
        errors.state = "State is Required."
    }

    if(!values.address.pincode){
        errors.pincode = "Pincode is Required."
    }
    
  return errors;
}
export default Validation;