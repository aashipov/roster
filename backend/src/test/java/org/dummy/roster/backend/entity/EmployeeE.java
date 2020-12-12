package org.dummy.roster.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Сотрудник.
 */
@Entity
@Table(name = "employee")
public class EmployeeE implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Имя.
     */
    private String name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private SalaryE salary;

    /**
     * Конструктор.
     */
    public EmployeeE() {
        //
    }

    public Long getId() {
        return id;
    }

    public EmployeeE setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeE setName(String name) {
        this.name = name;
        return this;
    }

    public SalaryE getSalary() {
        return salary;
    }

    public EmployeeE setSalary(SalaryE salary) {
        this.salary = salary;
        return this;
    }
}
