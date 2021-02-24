import React from 'react';
import {connect} from "react-redux";
import {saveEmployee} from "../actions";

/**
 * Строка таблицы Сотрудники.
 */
class EmployeeRow extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            employee: this.props.employee
        };
        this.onAmountChange = this.onAmountChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onAmountChange(evt) {
        evt.preventDefault();
        const {value} = evt.target;
        let tmp = this.state.employee;
        tmp.salary.amount = value;
        this.setState({employee: tmp});
    }

    onSubmit(evt) {
        evt.preventDefault();
        const {employee} = this.state;
        this.props.saveEmployee(employee);
    }

    render() {
        let {employee} = this.state;
        return (
            <tr>
                <td>{employee.name}</td>
                <td><input value={employee.salary.amount} onChange={this.onAmountChange}/></td>
                <td>
                    <button onClick={this.onSubmit}>Сохранить</button>
                </td>
            </tr>
        )
    }
}

const mapDispatchToProps = (dispatch) => ({saveEmployee: (employee) => dispatch(saveEmployee(employee))});

export default connect(null, mapDispatchToProps)(EmployeeRow);
