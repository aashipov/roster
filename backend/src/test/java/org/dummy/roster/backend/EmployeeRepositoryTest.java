package org.dummy.roster.backend;

import java.util.Currency;
import org.dummy.roster.backend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;
import static org.dummy.roster.backend.TestConstants.makeADummy;

/**
 * {@link Test} {@link EmployeeRepository}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

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
    public void saveTest() {
        Employee dummy = makeADummy();
        employeeRepository.save(dummy);

        Employee found = employeeRepository.findById(dummy.getId()).get();
        assertNotNull("employee", found);
        assertEquals("same name", TestConstants.DUMMY_NAME, dummy.getName());
        assertNotNull("salary", dummy.getSalary());
        assertEquals("currency", Currency.getInstance(TestConstants.CURRENCY), dummy.getSalary().getCurrency());

        employeeRepository.delete(dummy);
        assertFalse("employee deleted", employeeRepository.findById(dummy.getId()).isPresent());
        assertFalse("salary removed as well", salaryRepository.findById(dummy.getSalary().getId()).isPresent());
    }
}
