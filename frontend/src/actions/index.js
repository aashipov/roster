import {createEmployee, deleteAll, readAllEmployees, updateEmployee} from "../api";
import {ADD_EMPLOYEE, DELETE_ALL, GET_ALL_EMPLOYEES, UDATE_EMPLOYEE} from '../constants';

export const fetchAllEmployees = () => (dispatch) =>
    readAllEmployees()
        .then(response => dispatch({
            type: GET_ALL_EMPLOYEES,
            employees: response
        }));

export const addEmployee = (name, amount) => (dispatch) =>
    createEmployee({
        name: name,
        salary: {
            currency: 'RUR',
            amount: amount
        }
    })
        .then(r => dispatch({
            type: ADD_EMPLOYEE,
            employee: r
        }));

export const saveEmployee = (employee) => (dispatch) =>
    updateEmployee(employee)
        .then(r => dispatch({
            type: UDATE_EMPLOYEE,
            employee: r
        }));

export const removeAll = (user, password) => (dispatch) =>
    deleteAll(user, password)
        .then(r => dispatch({type: DELETE_ALL, employees: r}));
