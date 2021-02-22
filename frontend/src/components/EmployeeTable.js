import React, {Component} from 'react';
import {connect} from 'react-redux';
import Employee from "./EmployeeRow";
import {fetchAllEmployees} from "../actions";

/**
 * Таблица Сотркдники.
 */

class TableHeader extends Component {
    render() {
        return (
            <h3>Оклады сотрудников</h3>,
                <thead>
                <tr>
                    <th>Сотрудник</th>
                    <th>Оклад</th>
                    <th/>
                </tr>
                </thead>
        )
    }
}

class EmployeeTable extends Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
        this.props.fetchAllEmployees();
    }

    render() {
        let {employees} = this.props;
        return (
            <table>
                <TableHeader/>
                <tbody>{employees.map((employee, index) => <Employee key={index} employee={employee}/>)}</tbody>
            </table>
        )
    }
}

const mapStateToProps = (state) => ({employees: state.employees});

const mapDispatchToProps = (dispatch) => ({fetchAllEmployees: () => dispatch(fetchAllEmployees())});

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeTable);
