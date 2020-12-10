package org.dummy.roster.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Оклад {@link Employee}.
 */
@Entity
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

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
    @JoinColumn(name = "employee_id")
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

    public Currency getCurrency() {
        return currency;
    }

    public Salary setCurrency(Currency c) {
        this.currency = c;
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
