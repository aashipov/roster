import {createEmployee, readAllEmployees, updateEmployee} from "../api";
import {ADD_EMPLOYEE, GET_ALL_EMPLOYEES, UDATE_EMPLOYEE} from '../constants';

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
