package org.dummy.roster.backend;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;
import org.dummy.roster.backend.repository.SalaryRepository;
import org.dummy.roster.backend.service.RosterService;
import org.dummy.roster.backend.service.RosterServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static java.util.stream.Collectors.toList;
import static org.dummy.roster.backend.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Тесты {@link RosterService}.
 */
@RunWith(SpringRunner.class)
public class RosterServiceTest {

    /**
     * {@link TestConfiguration}.
     */
    @TestConfiguration
    static class RosterServiceTestContextConfiguration {
        @Bean
        public RosterService rosterService() {
            return new RosterServiceImpl();
        }
    }

    /**
     * {@link RosterService}.
     */
    @Autowired
    private RosterService rosterService;

    /**
     * {@link MockBean} {@link EmployeeRepository}.
     */
    @MockBean
    private EmployeeRepository employeeRepository;

    /**
     * {@link MockBean} {@link SalaryRepository}.
     */
    @MockBean
    private SalaryRepository salaryRepository;

    /**
     * {@link Before}.
     */
    @Before
    public void setUp() {
        Employee dummyWithIds = makeADummyWithIds();

        List<Employee> allEmployees = Stream.of(dummyWithIds).collect(toList());

        Mockito.when(employeeRepository.save(dummyWithIds)).thenReturn(dummyWithIds);
        Mockito.when(salaryRepository.save(dummyWithIds.getSalary())).thenReturn(dummyWithIds.getSalary());
        Mockito.when(employeeRepository.findById(dummyWithIds.getId())).thenReturn(Optional.of(dummyWithIds));
        Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
    }

    @Test
    public void saveTest() {
        Employee employee = rosterService.save(makeADummyWithIds());
        assertNotNull("dummy found", employee);
        assertEquals("dummy name", DUMMY_NAME, employee.getName());
        assertEquals("dummy uuid", DUMMY_ID, employee.getId());
        assertNotNull("salary", employee.getSalary());
        assertEquals("currency", CURRENCY, employee.getSalary().getCurrency());
        assertEquals("amount", AMOUNT, employee.getSalary().getAmount());
    }

    @Ignore
    @Test
    public void printUuidToStdout() {
        System.out.println(UUID.randomUUID());
    }
}
