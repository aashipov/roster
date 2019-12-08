package org.dummy.roster.backend.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Сотрудник.
 */
@Entity
public class Employee extends EntityWithUuid {

    private static final long serialVersionUID = 1L;

    /**
     * Имя.
     */
    private String name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
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
