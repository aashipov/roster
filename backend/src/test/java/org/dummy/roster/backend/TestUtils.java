package org.dummy.roster.backend;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
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
    public static final Currency CURRENCY = Currency.getInstance("RUR");
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1.23);

    /**
     * Конструктор.
     */
    private TestUtils() {
        //
    }

    /**
     * Создать тестового {@link Employee}.
     * @return {@link Employee}
     */
    public static Employee makeADummy() {
        Employee dummy = new Employee().setName(DUMMY_NAME);
        Salary salary = new Salary().setEmployee(dummy).setCurrency(CURRENCY).setAmount(AMOUNT);
        dummy.setSalary(salary);
        return dummy;
    }
}
