import {ADD_EMPLOYEE, DELETE_ALL, GET_ALL_EMPLOYEES, UDATE_EMPLOYEE} from '../constants';
import {combineReducers} from "redux";

const employees = (state = [], action) => { //nosonar
    switch (action.type) {
        case GET_ALL_EMPLOYEES: {
            return Object.assign([], state, action.employees);
        }
        case ADD_EMPLOYEE:
            return [
                ...state,
                action.employee
            ];
        case UDATE_EMPLOYEE: {
            state.map(
                (emp, idx) => {
                    if (emp.id === action.employee.id) {
                        Object.assign({}, emp, action.employee)
                    }
                }
            );
            return state;
        }
        case DELETE_ALL: {
            return [];
        }
        default:
            return state;
    }
};

export default combineReducers({employees});
