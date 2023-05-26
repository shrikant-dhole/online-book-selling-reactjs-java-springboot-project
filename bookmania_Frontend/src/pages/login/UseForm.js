import {useState,useEffect,useContext} from "react";
import Validation from "./Validation";
import UserService from "../../services/UserService";
import { useNavigate } from 'react-router-dom';
import { UserContext } from "../../App";
import { toast } from "react-toastify";

const useForm = (submitForm) => {
const navigate=useNavigate();


const [values,setValues] = useState({
    userEmail:"",
    password:"",
});

const [errors, setErrors] = useState({})
const [isLoggedIn, setIsLoggedIn    ] = useState(false)
const [dataIsCorrect, setDataIsCorrect] = useState(false);
const [dataAdded, setDataAdded] = useState('');

//const dispatch = useDispatch();

const handleChange = (event) =>{
    setValues({
        ...values,
        [event.target.name]: event.target.value,
    });
}
const handleFormSubmit = (event) =>{
    event.preventDefault();
    setErrors(Validation(values));
    setDataIsCorrect(true);
    UserService.login(values)
        .then(response => {
            console.log('Printing user data', response.data);
            //dispatch(updateSuccess(response.data))
            console.log(response.data.id,"customer id");
            if(response.data.id ==undefined){
                setDataAdded("Login failed check your password");
                alert("Login failed check your password");
                return null;
            }else{
            setDataAdded("Login Successful");
            setIsLoggedIn(true)
            }
            localStorage.setItem('user',JSON.stringify(response.data));
            localStorage.setItem("bookmaniauser", JSON.stringify(response.data));
            window.location.reload(true)
            return null;
            toast.success("you are logged in successfully");
            navigate('/');
            console.log("Login Successful");
            window.location.reload();

        })
        .catch(error => {
            console.log('Something went wrong', error);
            alert("Invalid email or password ");
            setDataAdded("Invalid email or password ");
          }) 
};

useEffect(() => {
    if(Object.keys(errors).length === 0 && dataIsCorrect){
        submitForm(true);
    }
}, [dataIsCorrect, errors, submitForm]);

return {handleChange,handleFormSubmit,errors,values,dataAdded,isLoggedIn};
}
export default useForm

