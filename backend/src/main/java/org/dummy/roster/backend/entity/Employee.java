package org.dummy.roster.backend.entity;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Сотрудник.
 */
@Entity
public class Employee implements Serializable {

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
