const axios = require('axios').default;

const BACKEND_URL = 'http://localhost:8080';

export const BASE_URL = `${process.env.NODE_ENV !== "production" ? BACKEND_URL : window.location.origin}`;
export function getAll() {
    return axios.get(BASE_URL + `/employees`).then(resp => {return resp.data});
}

