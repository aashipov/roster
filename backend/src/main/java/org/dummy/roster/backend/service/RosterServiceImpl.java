package org.dummy.roster.backend.service;

import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
import org.dummy.roster.backend.repository.EmployeeRepository;
import org.dummy.roster.backend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public E saveKludge(E employee) {
        E employeeCopy = (E) KludgeUtils.employeeShallowCopy(employee);
        employeeRepository.save(employeeCopy);
        S salaryCopy;
        Set<S> salariesCopy = new HashSet<>();
        for (S salary : (Set<S>) employee.getSalary()) {
            salaryCopy = (S) KludgeUtils.salaryShallowCopy(salary);
            salaryCopy.setEmployee(employeeCopy);
            salaryRepository.save(salaryCopy);
            salariesCopy.add(salaryCopy);
        }
        employeeCopy.setSalary((Set<Salary>) salariesCopy);
        return employeeRepository.save(employeeCopy);
    }

    @Override
    public List<E> findAll() {
        return (List<E>) employeeRepository.findAll();
    }
}
