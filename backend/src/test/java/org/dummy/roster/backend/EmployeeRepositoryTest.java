package org.dummy.roster.backend;

import java.math.BigDecimal;
import java.util.Currency;
import org.dummy.roster.backend.entity.Salary;
import org.dummy.roster.backend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;

import static org.junit.Assert.*;

/**
 * {@link Test} {@link EmployeeRepository}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    /**
     * {@link TestEntityManager}.
     */
    @Autowired
    private TestEntityManager entityManager;

    /**
     * {@link EmployeeRepository}.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    /**
     * {@link Test} {@link EmployeeRepository#findById(Object)}.
     */
    @Test
    public void findByIdTest() {
        Employee employee = new Employee().setName(TestConstants.DUMMY_NAME);
        entityManager.persist(employee);
        entityManager.flush();

        Salary salary = new Salary().setEmployee(employee).setCurrency(Currency.getInstance(TestConstants.CURRENCY)).setAmount(BigDecimal.valueOf(TestConstants.AMOUNT));
        entityManager.persist(salary);
        entityManager.flush();

        employee.setSalary(salary);
        entityManager.merge(employee);
        entityManager.flush();

        Employee found = employeeRepository.findById(employee.getId()).get();
        assertNotNull("employee", found);
        assertEquals("same name", TestConstants.DUMMY_NAME, employee.getName());
        assertNotNull("salary", employee.getSalary());
        assertEquals("currency", Currency.getInstance(TestConstants.CURRENCY), employee.getSalary().getCurrency());

        employeeRepository.delete(employee);
        assertFalse("employee deleted", employeeRepository.findById(employee.getId()).isPresent());
        assertFalse("salary removed as well", salaryRepository.findById(salary.getId()).isPresent());
    }
}
