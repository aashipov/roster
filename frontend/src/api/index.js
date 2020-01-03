const axios = require('axios').default;

const BACKEND_URL = `http://localhost:8080`;
const EMPLOYEES_PATH = `/employees`;
export const BASE_URL = `${process.env.NODE_ENV !== "production" ? BACKEND_URL : window.location.origin}`;

export function readAllEmployees() {
    return axios.get(BASE_URL + EMPLOYEES_PATH).then(resp => {return resp.data});
}

export function createEmployee(employee) {
    return axios.post(BASE_URL + EMPLOYEES_PATH, employee).then(resp => {return resp.data});
}

export function updateEmployee(employee) {
    return axios.put(BASE_URL + EMPLOYEES_PATH, employee).then(resp => {return resp.data});
}

