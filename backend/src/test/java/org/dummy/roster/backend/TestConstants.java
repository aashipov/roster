package org.dummy.roster.backend;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

/**
 * Константы тестов.
 */
public final class TestConstants {

    public static final String DUMMY_NAME = "John Doe";
    public static final UUID DUMMY_ID = UUID.fromString("1dfa8c95-a7c2-4139-88d0-a0bee00ac191");
    public static final Currency CURRENCY = Currency.getInstance("RUR");
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1.23);
    public static final UUID DUMMY_SALARY_ID = UUID.fromString("298e1653-2e1b-4de9-b56a-fda6d9113f03");

    /**
     * Конструктор.
     */
    private TestConstants() {
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

    /**
     * Создать тестового {@link Employee}, установить {@link UUID} {@link Employee} & {@link Salary}.
     * @return {@link Employee}
     */
    public static Employee makeADummyWithIds() {
        Employee dummy = makeADummy();
        dummy.setId(DUMMY_ID);
        dummy.getSalary().setId(DUMMY_SALARY_ID);
        return dummy;
    }
}
