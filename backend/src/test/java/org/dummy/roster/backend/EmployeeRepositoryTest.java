package org.dummy.roster.backend;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dummy.roster.backend.entity.Salary;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        employeeRepository.save(DUMMY);
    }

    @After
    public void tearDown() {
        employeeRepository.delete(DUMMY);
        assertFalse("employee deleted", employeeRepository.findById(DUMMY.getId()).isPresent());
    }


    /**
     * {@link Test} {@link EmployeeRepository#findById(Object)}.
     */
    @Test
    public void saveTest() {
        Employee found = employeeRepository.findById(DUMMY.getId()).get();
        assertNotNull("employee", found);
        assertEquals("same name", TestUtils.DUMMY_NAME, DUMMY.getName());
        assertNotNull("salary", DUMMY.getSalary());
        assertEquals("currency", TestUtils.CURRENCY, DUMMY.getSalary().getCurrency());
    }

    private static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<E>();
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

    private final String EMPLOYEE_SELECT = "SELECT e.id AS eid, e.name, s.id AS sid, s.currency, s.amount FROM employee e " +
            "LEFT JOIN salary s ON e.id = s.employee_id";
    private final RowMapper<Employee> rm = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setName(rs.getString("name"));
        //employee.setId(UUID.fromString(rs.getString("eid")));
        Salary salary = new Salary();
        salary.setCurrency(Currency.getInstance(rs.getString("currency")));
        salary.setAmount(BigDecimal.valueOf(rs.getDouble("amount")));
        //employee.setId(UUID.fromString(rs.getString("sid")));
        employee.setSalary(salary);
        return employee;
    };

    @Test
    public void selectComparison() {
        List<Employee> found;
        long[] jpa = new long[SAMPLE_SIZE];
        long[] jdbc = new long[SAMPLE_SIZE];
        long start;
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            found = (List<Employee>) makeCollection(employeeRepository.findAll());
            for (Employee employee : found) {
                LOG.log(Level.FINE, "salary {0}", employee.getSalary().getAmount());
            }
            jpa[i] = System.nanoTime() - start;
        }
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            found = jdbcTemplate.query(EMPLOYEE_SELECT, rm);
            for (Employee employee : found) {
                LOG.log(Level.FINE, "salary {0}", employee.getSalary().getAmount());
            }
            jdbc[i] = System.nanoTime() - start;
        }
        double jpaAvg = avg(jpa);
        double jdbcAvg = avg(jdbc);
        LOG.log(Level.INFO, "jpa {0} {1} {2}", new Object[]{jpaAvg, PLUS_MINUS_SIGN, sd(jpa, jpaAvg)});
        LOG.log(Level.INFO, "jdbc {0} {1} {2}", new Object[]{jdbcAvg, PLUS_MINUS_SIGN, sd(jdbc, jdbcAvg)});
    }
}
