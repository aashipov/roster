package org.dummy.roster.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Оклад {@link EmployeeE}.
 */
@Entity
@Table(name = "salary")
public class SalaryE implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Оклад {@link EmployeeE}.
     */
    private BigDecimal amount;

    /**
     * {@link EmployeeE}.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private EmployeeE employee;

    /**
     * Конструктор.
     */
    public SalaryE() {
        //
    }

    public Long getId() {
        return id;
    }

    public SalaryE setId(Long id) {
        this.id = id;
        return this;
    }

    public EmployeeE getEmployee() {
        return employee;
    }

    public SalaryE setEmployee(EmployeeE employee) {
        this.employee = employee;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public SalaryE setAmount(BigDecimal salary) {
        this.amount = salary;
        return this;
    }
}
