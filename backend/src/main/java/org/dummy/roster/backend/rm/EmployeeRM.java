package org.dummy.roster.backend.rm;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

import org.dummy.roster.backend.entity.Salary;
import org.springframework.jdbc.core.RowMapper;
import org.dummy.roster.backend.entity.Employee;

/**
 * {@link RowMapper} к {@link Employee}.
 */
public class EmployeeRM implements RowMapper<Employee> {

    private static final String SELECT =
            "SELECT e.id AS eid, e.name, s.id AS sid, s.currency, s.amount FROM employee e " +
            "LEFT JOIN salary s ON e.id = s.employee_id";

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setName(rs.getString("name"));
        employee.setId(rs.getLong("eid"));
        Salary salary = new Salary();
        salary.setCurrency(Currency.getInstance(rs.getString("currency")));
        salary.setAmount(BigDecimal.valueOf(rs.getDouble("amount")));
        employee.setId(rs.getLong("sid"));
        employee.setSalary(salary);
        return employee;
    }

    public static String select() {
        return SELECT;
    }
}
