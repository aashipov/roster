import {createEmployee, deleteAll, readAllEmployees, updateEmployee} from "../api";
import {ADD_EMPLOYEE, DELETE_ALL, GET_ALL_EMPLOYEES, UDATE_EMPLOYEE} from '../constants';

export function fetchAllEmployees() {
    return function (dispatch) {
        return readAllEmployees().then(response => dispatch({type: GET_ALL_EMPLOYEES, employees: response}));
    }
}

export function addEmployee(name, amount) {
    return function (dispatch) {
        createEmployee({
            name: name,
            salary: {
                currency: 'RUR',
                amount: amount
            }
        }).then(r => dispatch({
            type: ADD_EMPLOYEE,
            employee: r
        }))
    }
}

export function saveEmployee(employee) {
    return function (dispatch) {
        updateEmployee(employee).then(r => dispatch({
            type: UDATE_EMPLOYEE,
            employee: r
        }))
    }
}

export function removeAll(user, password) {
    return function (dispatch) {
        deleteAll(user, password).then(r => dispatch({type : DELETE_ALL, employees: r}))
    }
}
