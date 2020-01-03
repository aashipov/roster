import React, {Component} from 'react';
import {connect} from 'react-redux';
import Employee from "./EmployeeRow";
import {getAll} from "../api";
import {loadAllEmployees} from "../actions";

/**
 * Таблица Сотркдники.
 */
const TableHeader = () => {
    return (
        <thead>
        <tr>
            <th>Сотрудник</th>
            <th>Оклад</th>
            <th/>
        </tr>
        </thead>
    )
};

class EmployeeTable extends Component {

    constructor(props) {
        super(props);
    }

    refreshList() {
        getAll().then(e => {
            this.props.loadAllEmployees(e)
        });
    }

    componentDidMount() {
        this.refreshList();
    }

    render() {
        let {employees} = this.props;
        return (
            <table>
                <TableHeader/>
                <tbody>
                {employees.map((employee, index) => {
                    return (<Employee key={index} employee={employee}/>)
                })}
                </tbody>
            </table>
        )
    }
}

const mapStateToProps = function (state) {
    return {
        employees: state.employees
    }
};

const mapDispatchToProps = function (dispatch) {
    return {
        loadAllEmployees: employees => dispatch(loadAllEmployees(employees))
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeTable);
