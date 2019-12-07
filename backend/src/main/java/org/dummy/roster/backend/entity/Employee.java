package org.dummy.roster.backend.entity;

import javax.persistence.*;
import java.util.Set;
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

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Salary> salary;

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

    public Set<Salary> getSalary() {
        return salary;
    }

    public Employee setSalary(Set<Salary> salary) {
        this.salary = salary;
        return this;
    }

}
