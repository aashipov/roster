const axios = require('axios').default;

const DEFAULT_LOCALHOST = `http://localhost:8080`;
const API_V1 = `/api/v1`;
const EMPLOYEES = `/employees`;
const BACKEND = `${process.env.NODE_ENV !== "production" ? DEFAULT_LOCALHOST : window.location.origin}`;
const API_V1_EMPLOYEES = BACKEND + API_V1 + EMPLOYEES;

export function readAllEmployees() {
    return axios.get(API_V1_EMPLOYEES).then(resp => {
        return resp.data
    });
}

export function createEmployee(employee) {
    return axios.post(API_V1_EMPLOYEES, employee).then(resp => {
        return resp.data
    });
}

export function updateEmployee(employee) {
    return axios.put(API_V1_EMPLOYEES + `/` + employee.id, employee).then(resp => {
        return resp.data
    });
}

//Fails in node.js
export function deleteAll(user, password) {
    return axios
        .delete(API_V1_EMPLOYEES, {headers: {Authorization: "Basic " + btoa(user + ":" + password)}})
        .then(resp => {
            return resp
        });
}

