package org.dummy.roster.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * {@link Test} {@link EmployeeRepository}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIT {

    private static final String DUMMY_NAME = "John Doe";

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

    /**
     * {@link Test} {@link EmployeeRepository#findById(Object)}.
     */
    @Test
    public void findByIdTest() {
        Employee employee = new Employee().setName(DUMMY_NAME);
        entityManager.persist(employee);
        entityManager.flush();

        Employee found = employeeRepository.findById(employee.getUuid()).get();
        assertNotNull("not null", found);
        assertEquals("same name", DUMMY_NAME, employee.getName());
    }
}
