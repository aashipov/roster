import React from 'react';
import {connect} from "react-redux";
import {addEmployee} from "../actions";

/**
 * Добавить Сотрудника.
 */
const AddEmployee = ({dispatch}) => {
    let nameInput, amountInput;
    return (
        <div>
            <form id={'add-employee'} onSubmit={evt => {
                evt.preventDefault();
                if (!('' + nameInput.value).trim() || !('' + amountInput.value).trim()) {
                    return;
                }
                dispatch(addEmployee(nameInput.value, amountInput.value));
                nameInput.value = '';
                amountInput.value = '';
            }}>
                <label>Имя:</label>
                <input id={'add-employee-name'} ref={node => {
                    nameInput = node;
                }}/>
                <label>Оклад:</label>
                <input id={'add-employee-amount'} ref={node => {
                    amountInput = node;
                }}/>
                <button id={'add-employee-submit'} type={"submit"}>Создать</button>
            </form>
        </div>
    )
};

export default connect()(AddEmployee);
