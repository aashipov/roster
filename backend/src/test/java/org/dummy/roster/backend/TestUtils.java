package org.dummy.roster.backend;

import org.dummy.roster.backend.dto.Employee;
import org.dummy.roster.backend.entity.EmployeeE;
import org.dummy.roster.backend.dto.Salary;
import org.dummy.roster.backend.entity.SalaryE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Вспомогательные функции тестов.
 */
public final class TestUtils {

    public static final String DUMMY_NAME = "John Doe";
    public static final BigDecimal DUMMY_AMOUNT = BigDecimal.valueOf(1.23);
    public static final EmployeeE DUMMY_EMPLOYEE_E = makeDummyEmployeeE();
    public static final Employee DUMMY_EMPLOYEE = makeDummyEmployee();

    /**
     * Конструктор.
     */
    private TestUtils() {
        //
    }

    /**
     * Создать тестового {@link EmployeeE}.
     * @return {@link EmployeeE}
     */
    public static EmployeeE makeDummyEmployeeE() {
        EmployeeE dummy = new EmployeeE().setName(DUMMY_NAME);
        SalaryE salary = new SalaryE().setEmployee(dummy).setAmount(DUMMY_AMOUNT);
        dummy.setSalary(salary);
        return dummy;
    }

    /**
     * Создать тестового {@link Employee}.
     * @return {@link Employee}
     */
    public static Employee makeDummyEmployee() {
        Employee dummy = new Employee().setName(DUMMY_NAME);
        Salary salary = new Salary().setEmployee(dummy).setAmount(DUMMY_AMOUNT);
        dummy.setSalary(salary);
        return dummy;
    }

    public static void reassureE(EmployeeE found) {
        assertNotNull("employee", found);
        assertEquals("same name", DUMMY_NAME, found.getName());
        assertNotNull("salary", found.getSalary());
        assertNotNull("amount", found.getSalary().getAmount());
        assertEquals("amount", DUMMY_AMOUNT, found.getSalary().getAmount());
    }

    public static void reassure(Employee found) {
        assertNotNull("employee", found);
        assertEquals("same name", DUMMY_NAME, found.getName());
        assertNotNull("salary", found.getSalary());
        assertNotNull("amount", found.getSalary().getAmount());
        assertEquals("amount", DUMMY_AMOUNT, found.getSalary().getAmount());
    }

}
