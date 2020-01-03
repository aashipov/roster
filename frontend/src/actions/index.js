import {readAllEmployees} from "../api";
import {ADD_EMPLOYEE, GET_ALL_EMPLOYEES, UDATE_EMPLOYEE} from '../constants';

let nextEmployeeId = 1;
let nextSalaryId = 1;

export function fetchAllEmployees() {
    return function (dispatch) {
        return readAllEmployees().then(response => dispatch({type: GET_ALL_EMPLOYEES, employees: response}));
    }
}

export const addEmployee = (name, amount) => ({
    type: ADD_EMPLOYEE,
    id: ++nextEmployeeId,
    name: name,
    salary: {
        id: ++nextSalaryId,
        currency: 'RUR',
        amount: amount
    }
});

export const updateEmployee = employee => ({
    type: UDATE_EMPLOYEE,
    employee
});
