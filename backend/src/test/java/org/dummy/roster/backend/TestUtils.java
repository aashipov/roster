package org.dummy.roster.backend;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.EmployeeE;
import org.dummy.roster.backend.entity.Salary;
import org.dummy.roster.backend.entity.SalaryE;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Currency;
import java.util.UUID;

/**
 * Вспомогательные функции тестов.
 */
public final class TestUtils {

    public static final String DUMMY_NAME = "John Doe";
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1.23);

    /**
     * Конструктор.
     */
    private TestUtils() {
        //
    }

    /**
     * Создать тестового {@link EmployeeE}.
     * @return {@link Employee}
     */
    public static EmployeeE makeADummy() {
        EmployeeE dummy = new EmployeeE().setName(DUMMY_NAME);
        SalaryE salary = new SalaryE().setEmployee(dummy).setAmount(AMOUNT);
        dummy.setSalary(salary);
        return dummy;
    }
}
