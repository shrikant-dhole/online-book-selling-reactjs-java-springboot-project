import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Sell from "./pages/Sell";
import About from "./pages/About";
import Home from "./pages/Home";
import Login from "./pages/login/Login";
import Registration from "./pages/Registration";
import ForgotPassword from "./pages/ForgotPassword";
import Corousel from "./components/Corousel";
import UserCart from "./pages/UserCart";
import Payment from "./pages/Payment";
import ProductHome from "./pages/ProductHome";
import axios from "axios";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { createContext, useReducer } from "react";
import { initialState, reducer } from "./reducers/UserReducer";

export const UserContext = createContext();

const App = () => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <UserContext.Provider value={{ state, dispatch }}>
        <Navbar />
        <Corousel />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="about" element={<About />} />
          <Route path="sell" element={<Sell />} />
          <Route path="login" element={<Login />} />
          <Route path="registration" element={<Registration />} />
          <Route path="forgotpassword" element={<ForgotPassword />} />
          <Route path="mycart" element={<UserCart />} />
          <Route path="payment" element={<Payment />} />
        </Routes>
        <ProductHome />
        <Footer />
      </UserContext.Provider>
    </div>
  );
};

export default App;
