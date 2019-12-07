package org.dummy.roster.backend.service;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;

/**
 * Костыль по ТЗ.
 */
public final class KludgeUtils {

    /**
     * Конструктор.
     */
    private KludgeUtils() {
        //
    }


    /**
     * Поверхностная копия {@link Employee}.
     * @param another {@link Employee}-образец
     * @return
     */
    public static Employee employeeShallowCopy(Employee another) {
        return (new Employee())
                .setName(another.getName());
    }

    /**
     * Поверхностная копия {@link Salary}.
     * @param another {@link Salary}-образец
     * @return {@link Salary}
     */
    public static Salary salaryShallowCopy(Salary another) {
        return (new Salary())
                .setCurrency(another.getCurrency())
                .setAmount(another.getAmount());
    }
}
