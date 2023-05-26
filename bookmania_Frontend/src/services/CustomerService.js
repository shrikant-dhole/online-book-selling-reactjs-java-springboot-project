import { myAxios } from "./Common-helper";

 export const createAccount =(data)=>{
    return myAxios.post('/customer/register',data);
};

export const sellBook =(data,id)=>{
    return myAxios.post(`/customer/${id}/sell`,data);
};

export  default {createAccount,sellBook}