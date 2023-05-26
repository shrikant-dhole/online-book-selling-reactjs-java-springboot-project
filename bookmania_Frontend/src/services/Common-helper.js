import axios from "axios";
export const  BASE_URL ='http://localhost:8087/api/bookshop';
export const myAxios =axios.create({
    baseURL:BASE_URL,
    headers: {
        'Content-Type': 'application/json',
      },
})