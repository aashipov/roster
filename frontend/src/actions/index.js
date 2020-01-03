import {createEmployee, readAllEmployees} from "../api";
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

export const updateEmployee = employee => ({
    type: UDATE_EMPLOYEE,
    employee
});
