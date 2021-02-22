import React from 'react';
import EmployeeList from "./components/EmployeeTable";
import Employee from "./components/AddEmployee";
import DeleteAll from "./components/DeleteAll";

const App = () => (
    <div>
        <Employee/>
        <EmployeeList/>
        <DeleteAll/>
    </div>
);

export default App
