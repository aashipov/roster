package org.dummy.roster.backend.dao;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAO {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AMOUNT = "amount";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT_ALL =
            "SELECT e.id AS eid, e.name, s.id AS sid, s.amount FROM employee e " +
                    "LEFT JOIN salary s ON e.id = s.employee_id";

    private static final String SELECT_BY_ID = SELECT_ALL
            + " "
            + "WHERE e.id = :id";

    private static final String CREATE_SALARY = "INSERT INTO salary (amount, employee_id) VALUES (:amount, :employee_id)";

    private static final String CREATE_EMPLOYEE = "INSERT INTO employee (name) VALUES (:name)";

    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = :name WHERE id = :id";

    private static final String UPDATE_SALARY = "UPDATE salary SET amount = :amount, employee_id = :employee_id WHERE id = :id";

    private static final String DELETE_ALL_SALARIES = "DELETE FROM salary WHERE (1 = 1)";

    private static final String DELETE_ALL_EMPLOYEES = "DELETE FROM employee WHERE (1 = 1)";

    private static final EmployeeRM ERM = new EmployeeRM();

    public EmployeeDAO(NamedParameterJdbcTemplate n) {
        this.namedParameterJdbcTemplate = n;
    }

    public List<Employee> readAll() {
        return namedParameterJdbcTemplate.query(SELECT_ALL, ERM);
    }

    private static Map<String, Object> byId(Long id) {
        Map<String, Object> map = new HashMap<>(1);
        if (null != id) {
            map.put(ID, id);
        }
        return map;
    }

    private static Map<String, Object> salary(Salary salary) {
        Map<String, Object> map = byId(salary.getId());
        map.put("employee_id", salary.getEmployee().getId());
        map.put(AMOUNT, salary.getAmount());
        return map;
    }

    private static Map<String, Object> employee(Employee employee) {
        Map<String, Object> map = byId(employee.getId());
        map.put(NAME, employee.getName());
        return map;
    }

    public Employee read(Long id) {
        SqlParameterSource sqlParams = new MapSqlParameterSource(byId(id));
        return namedParameterJdbcTemplate.queryForObject(SELECT_BY_ID, sqlParams, ERM);
    }

    public Employee create(Employee employee) {
        if (null != employee && null != employee.getSalary() && null == employee.getId()) {
            KeyHolder idHolder = new GeneratedKeyHolder();
            SqlParameterSource sqlParams = new MapSqlParameterSource(employee(employee));
            namedParameterJdbcTemplate.update(CREATE_EMPLOYEE, sqlParams, idHolder, new String[]{ID});
            employee.setId(idHolder.getKey().longValue());

            sqlParams = new MapSqlParameterSource(salary(employee.getSalary()));
            idHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(CREATE_SALARY, sqlParams, idHolder, new String[]{ID});
            employee.getSalary().setId(idHolder.getKey().longValue());
        }
        return employee;
    }

    public Employee update(Employee employee) {
        Map<String, Object> params = employee(employee);
        SqlParameterSource sqlParams = new MapSqlParameterSource(params);
        namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE, sqlParams);
        params = salary(employee.getSalary());
        sqlParams = new MapSqlParameterSource(params);
        namedParameterJdbcTemplate.update(UPDATE_SALARY, sqlParams);
        return read(employee.getId());
    }

    public void deleteAll() {
        namedParameterJdbcTemplate.update(DELETE_ALL_SALARIES, Collections.emptyMap());
        namedParameterJdbcTemplate.update(DELETE_ALL_EMPLOYEES, Collections.emptyMap());
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
