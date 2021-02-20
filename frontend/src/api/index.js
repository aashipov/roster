const axios = require('axios').default;

const DEFAULT_LOCALHOST = `http://localhost:8080`;
const API_V1 = `/api/v1`;
const EMPLOYEES = `/employees`;
const BACKEND = `${process.env.NODE_ENV !== "production" ? DEFAULT_LOCALHOST : window.location.origin}`;
const API_V1_EMPLOYEES = BACKEND + API_V1 + EMPLOYEES;

export const readAllEmployees = () =>
    axios
        .get(API_V1_EMPLOYEES)
        .then((resp) => resp.data);

export const createEmployee = (employee) =>
    axios
        .post(API_V1_EMPLOYEES, employee)
        .then((resp) => resp.data);

export const updateEmployee = (employee) =>
    axios
        .put(API_V1_EMPLOYEES + `/` + employee.id, employee)
        .then((resp) => resp.data);

export const deleteAll = (user, password) =>
    axios
        .delete(API_V1_EMPLOYEES, {headers: {Authorization: "Basic " + btoa(user + ":" + password)}})
        .then((resp) => resp);
