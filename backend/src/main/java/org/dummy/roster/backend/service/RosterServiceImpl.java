package org.dummy.roster.backend.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
import org.dummy.roster.backend.repository.EmployeeRepository;
import org.dummy.roster.backend.repository.SalaryRepository;


/**
 * Реализация {@link RosterService}.
 */
@Service
public class RosterServiceImpl<E extends Employee, S extends Salary> implements RosterService<E, S> {

    /**
     * {@link EmployeeRepository}.
     */
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * {@link SalaryRepository}.
     */
    @Autowired
    SalaryRepository salaryRepository;

    @Override
    public E save(E employee) {
        employeeRepository.save(employee);
        return this.findById(employee.getId());
    }

    @Override
    public List<E> findAll() {
        return (List<E>) employeeRepository.findAll();
    }

    @Override
    public E findById(UUID uuid) {
        return  (E) employeeRepository.findById(uuid).get();
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public S changeSalary(Salary salary) {
        S persisted = (S) salaryRepository.findById(salary.getId()).get();
        persisted.setCurrency(salary.getCurrency()).setAmount(salary.getAmount());
        return salaryRepository.save(persisted);
    }
}
