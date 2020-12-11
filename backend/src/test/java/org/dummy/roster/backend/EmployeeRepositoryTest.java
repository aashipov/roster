package org.dummy.roster.backend;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.dummy.roster.backend.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;
import static org.junit.Assert.*;
import static org.dummy.roster.backend.TestUtils.makeADummy;

/**
 * {@link Test} {@link EmployeeRepository}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:integration-test.properties")
public class EmployeeRepositoryTest {

    private static Employee DUMMY = makeADummy();
    private static final int SAMPLE_SIZE = 100_000;
    private static final String PLUS_MINUS_SIGN = "\u00B1";
    private static final Logger LOG = Logger.getLogger(EmployeeRepositoryTest.class.getSimpleName());

    /**
     * {@link EmployeeRepository}.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * {@link NamedParameterJdbcTemplate}.
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * {@link EmployeeDAO}.
     */
    private EmployeeDAO employeeDAO;

    @PostConstruct
    private void pc() {
        this.employeeDAO = new EmployeeDAO(this.namedParameterJdbcTemplate);
    }

    @Before
    public void setUp() {
        employeeRepository.save(DUMMY);
    }

    @After
    public void tearDown() {
        employeeRepository.delete(DUMMY);
        assertFalse("employee deleted", employeeRepository.findById(DUMMY.getId()).isPresent());
    }

    private static void reassure(Employee found) {
        assertNotNull("employee", found);
        assertEquals("same name", TestUtils.DUMMY_NAME, found.getName());
        assertNotNull("salary", found.getSalary());
        assertNotNull("amount", found.getSalary().getAmount());
        assertEquals("amount", TestUtils.AMOUNT, found.getSalary().getAmount());
    }

    /**
     * {@link Test} {@link EmployeeRepository#findById(Object)}.
     */
    @Test
    public void readTest() {
        Employee found = employeeRepository.findById(DUMMY.getId()).get();
        reassure(found);
    }

    private static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<>(0);
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }

    /**
     * Calculate average.
     * @param a array of long
     * @return sum
     */
    private static double avg(long[] a) {
        if (a.length > 0) {
            double sum = 0;
            for (long e : a) {
                sum = sum + e;
            }
            return sum / a.length;
        }
        return 0;
    }

    /**
     * Calculate standard deviation.
     * @param a array of long
     * @param avg average
     * @return SD
     */
    private static double sd(long[] a, double avg) {
        if (a.length > 0) {
            double sum = 0;
            for (long e : a) {
                sum = sum + Math.pow((e - avg), 2);
            }
            return Math.sqrt(sum / a.length);
        }
        return 0;
    }

    @Test
    public void selectComparison() {
        List<Employee> employeeList;
        long[] jpa = new long[SAMPLE_SIZE];
        long[] jdbc = new long[SAMPLE_SIZE];
        long start;
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            employeeList = (List<Employee>) makeCollection(employeeRepository.findAll());
            for (Employee found : employeeList) {
                reassure(found);
            }
            jpa[i] = System.nanoTime() - start;
        }
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            employeeList = (List<Employee>) makeCollection(employeeDAO.readAll());
            for (Employee found : employeeList) {
                reassure(found);
            }
            jdbc[i] = System.nanoTime() - start;
        }
        double jpaAvg = avg(jpa);
        double jdbcAvg = avg(jdbc);
        LOG.log(Level.INFO, "jpa {0} {1} {2}", new Object[]{jpaAvg, PLUS_MINUS_SIGN, sd(jpa, jpaAvg)});
        LOG.log(Level.INFO, "jdbc {0} {1} {2}", new Object[]{jdbcAvg, PLUS_MINUS_SIGN, sd(jdbc, jdbcAvg)});
    }
}
