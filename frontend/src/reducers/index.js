import {ADD_EMPLOYEE, GET_ALL_EMPLOYEES} from '../constants';
import {combineReducers} from "redux";

const employees = (state = [], action) => {
    switch (action.type) {
        case GET_ALL_EMPLOYEES : {
            return Object.assign([], state, action.employees);
        }
        case ADD_EMPLOYEE :
            return [
                ...state,
                action.employee
            ];
        default:
            return state;
    }
};

export default combineReducers({employees});
