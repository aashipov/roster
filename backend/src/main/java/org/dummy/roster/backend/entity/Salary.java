package org.dummy.roster.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Оклад {@link Employee}.
 */
@Entity
public class Salary extends EntityWithUuid {

    private static final long serialVersionUID = 1L;

    /**
     * Валюта оклада.
     */
    private Currency currency;

    /**
     * Оклад {@link Employee}.
     */
    private BigDecimal amount;

    /**
     * {@link Employee}.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_uuid")
    @JsonBackReference
    private Employee employee;

    /**
     * Конструктор.
     */
    public Salary() {
        super();
    }

    public Currency getCurrency() {
        return currency;
    }

    public Salary setCurrency(Currency salary) {
        this.currency = salary;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Salary setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Salary setAmount(BigDecimal salary) {
        this.amount = salary;
        return this;
    }

}
