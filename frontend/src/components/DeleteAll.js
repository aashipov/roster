import React from "react";
import {removeAll} from "../actions";
import {connect} from "react-redux";

/**
 * Удалить все.
 */
const DeleteAll = ({dispatch}) => {
    return (
        <div>
            <form id={'delete all-employees'} onSubmit={evt => {
                evt.preventDefault();
                dispatch(removeAll());
            }}>
                <button id={'delete all-employees-submit'} type={"submit"}>Удалить все</button>
            </form>
        </div>
    )
};

export default connect()(DeleteAll);
