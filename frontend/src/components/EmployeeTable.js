import React from 'react';
import {connect} from 'react-redux';
import {fetchAllEmployees} from "../actions";
import EmployeeRow from "./EmployeeRow";

/**
 * Таблица Сотркдники.
 */

class TableHeader extends React.Component {
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

class EmployeeTable extends React.Component {

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
                <tbody>
                {employees.map((employee, index) => <EmployeeRow key={index} employee={employee}/>)}
                </tbody>
            </table>
        )
    }
}

const mapStateToProps = (state) => ({employees: state.employees});

const mapDispatchToProps = (dispatch) => ({fetchAllEmployees: () => dispatch(fetchAllEmployees())});

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeTable);
