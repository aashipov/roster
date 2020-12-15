package org.dummy.roster.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Оклад {@link Employee}.
 */
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    protected Long id;

    /**
     * Оклад {@link Employee}.
     */
    private BigDecimal amount;

    /**
     * {@link Employee}.
     */
    @JsonBackReference
    private Employee employee;

    /**
     * Конструктор.
     */
    public Salary() {
        //
    }

    public Long getId() {
        return id;
    }

    public Salary setId(Long id) {
        this.id = id;
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
