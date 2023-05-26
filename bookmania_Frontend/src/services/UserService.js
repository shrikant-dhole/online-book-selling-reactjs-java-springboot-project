import { myAxios } from "./Common-helper";

export const login = (data) => {
    return myAxios.post('/user/login', data);
  };
  export const logout = () => {
    return myAxios.get('/user/logout');
  };
  export const getallproducts = () => {
    return myAxios.get('/user/getallCategories');
  };
  export default{login, logout}
  // we need api to get all books