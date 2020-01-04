package org.dummy.roster.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Сотрудник.
 */
@Entity
public class Employee extends EntityWithId {

    private static final long serialVersionUID = 1L;

    /**
     * Имя.
     */
    @NotNull
    private String name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Salary salary;

    /**
     * Конструктор.
     */
    public Employee() {
        super();
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
