package org.dummy.roster.backend.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Сотрудник.
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Первичный ключ.
     */
    protected Long id;

    /**
     * Имя.
     */
    private String name;

    @JsonManagedReference
    private Salary salary;

    /**
     * Конструктор.
     */
    public Employee() {
        //
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Salary getSalary() {
        return salary;
    }

    public Employee setSalary(Salary salary) {
        this.salary = salary;
        return this;
    }
}
