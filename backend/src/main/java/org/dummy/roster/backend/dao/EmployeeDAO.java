package org.dummy.roster.backend.dao;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAO {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AMOUNT = "amount";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT =
            "SELECT e.id AS eid, e.name, s.id AS sid, s.amount FROM employee e " +
                    "LEFT JOIN salary s ON e.id = s.employee_id";

    private static final String CREATE_SALARY = "INSERT INTO salary (amount, employee_id) VALUES (:amount, :employee_id)";

    private static final String CREATE_EMPLOYEE = "INSERT INTO employee (name) VALUES (:name)";

    private static final EmployeeRM ERM = new EmployeeRM();

    public EmployeeDAO(NamedParameterJdbcTemplate n) {
        this.namedParameterJdbcTemplate = n;
    }

    public List<Employee> readAll() {
        return namedParameterJdbcTemplate.query(SELECT, ERM);
    }

    private static Map<String, Object> salary(Salary salary) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("employee_id", salary.getEmployee().getId());
        map.put(AMOUNT, salary.getAmount());
        return map;
    }

    public Employee create(Employee employee) {
        if (null != employee && null != employee.getSalary() && null == employee.getId()) {
            Map<String, Object> employeeParams = new HashMap<>(1);
            employeeParams.put(NAME, employee.getName());
            KeyHolder keyHolder = new GeneratedKeyHolder();
            SqlParameterSource employeeSqlParam = new MapSqlParameterSource(employeeParams);
            namedParameterJdbcTemplate.update(CREATE_EMPLOYEE, employeeSqlParam, keyHolder, new String[]{ID});
            employee.setId(keyHolder.getKey().longValue());

            Map<String, Object> salaryParams = salary(employee.getSalary());
            SqlParameterSource salarySqlParam = new MapSqlParameterSource(salaryParams);
            keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(CREATE_SALARY, salarySqlParam, keyHolder, new String[]{ID});
            employee.getSalary().setId(keyHolder.getKey().longValue());
        }
        return employee;
    }

    private static class EmployeeRM implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setName(rs.getString(NAME));
            employee.setId(rs.getLong("eid"));
            Salary salary = new Salary();
            salary.setAmount(BigDecimal.valueOf(rs.getDouble(AMOUNT)));
            salary.setId(rs.getLong("sid"));
            employee.setSalary(salary);
            salary.setEmployee(employee);
            return employee;
        }
    }
}
