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

    private static final String DUMMY_NAME = "John Doe";
    private static final String CURRENCY = "RUR";
    private static final Double AMOUNT = Double.valueOf(1.23);

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
        Employee employee = new Employee().setName(DUMMY_NAME);
        entityManager.persist(employee);
        entityManager.flush();

        Salary salary = new Salary().setEmployee(employee).setCurrency(Currency.getInstance(CURRENCY)).setAmount(BigDecimal.valueOf(AMOUNT));
        entityManager.persist(salary);
        entityManager.flush();

        employee.setSalary(salary);
        entityManager.merge(employee);
        entityManager.flush();

        Employee found = employeeRepository.findById(employee.getUuid()).get();
        assertNotNull("employee", found);
        assertEquals("same name", DUMMY_NAME, employee.getName());
        assertNotNull("salary", employee.getSalary());
        assertEquals("currency", Currency.getInstance(CURRENCY), employee.getSalary().getCurrency());

        employeeRepository.delete(employee);
        assertFalse("employee deleted", employeeRepository.findById(employee.getUuid()).isPresent());
        assertFalse("salary removed as well", salaryRepository.findById(salary.getUuid()).isPresent());
    }
}
