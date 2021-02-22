import React from "react";
import {removeAll} from "../actions";
import {connect} from "react-redux";

/**
 * Удалить все.
 */
const DeleteAll = ({dispatch}) => {
    let userInput, passwordInput;
    return (
        <div>
            <form id={'delete all-employees'} onSubmit={
                evt => {
                    evt.preventDefault();
                    if (!('' + userInput.value).trim() || !('' + passwordInput.value).trim()) {
                        return;
                    }
                    dispatch(removeAll(userInput.value, passwordInput.value));
                    userInput.value = '';
                    passwordInput.value = '';
                }
            }>
                <h3>Удалить все</h3>
                <label>Имя пользователя</label>
                <input id={'delete-all-employees-user'} ref={
                    node => {
                        userInput = node
                    }
                }/>
                <label>Пароль</label>
                <input id={'delete-all-employees-password'} ref={
                    node => {
                        passwordInput = node
                    }
                }/>
                <button id={'delete all-employees-submit'} type={"submit"}>Удалить все</button>
            </form>
        </div>
    )
};

export default connect()(DeleteAll);
