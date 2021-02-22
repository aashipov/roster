package org.dummy.roster.backend;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.dummy.roster.backend.dao.EmployeeDAO;
import org.dummy.roster.backend.repo.EmployeeERepository;
import org.dummy.roster.backend.utils.CollectionUtils;
import org.dummy.roster.backend.utils.MathsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.dummy.roster.backend.dto.Employee;
import static org.dummy.roster.backend.TestUtils.*;
import static org.junit.Assert.assertEquals;

/**
 * {@link Test} {@link EmployeeERepository}.
 */
@RunWith(SpringRunner.class)
@JdbcTest
//@TestPropertySource(locations = "classpath:integration-test.properties")
public class DataAccessTest {

    public static final Logger LOG = Logger.getLogger(DataAccessTest.class.getSimpleName());

    /**
     * {@link NamedParameterJdbcTemplate}.
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private DataSource dataSource;

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
        employeeDAO.create(DUMMY_EMPLOYEE);
    }

    @After
    public void tearDown() {
        employeeDAO.deleteAll();
        assertEquals("no employees", 0, employeeDAO.readAll().size());
    }

    @Test
    public void readTest() {
        List<Employee> found = employeeDAO.readAll();
        assertEquals("one employee", 1, found.size());
        assertEquals(DUMMY_EMPLOYEE.getName(), found.get(0).getName());
        assertEquals(DUMMY_EMPLOYEE.getSalary().getAmount(), found.get(0).getSalary().getAmount());
    }

    @SuppressWarnings("java:S2699")
    @Test
    public void selectComparison() {
        long[] springJdbc = new long[MathsUtils.SAMPLE_SIZE];
        long[] pureJdbc = new long[MathsUtils.SAMPLE_SIZE];
        long start;

        for (int i = 0; i < MathsUtils.SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            List<Employee> employeeList = (List<Employee>) CollectionUtils.makeCollection(employeeDAO.readAll());
            for (Employee found : employeeList) {
                TestUtils.reassure(found);
            }
            springJdbc[i] = System.nanoTime() - start;
        }
        for (int i = 0; i < MathsUtils.SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            List<Employee> employeeList = (List<Employee>) CollectionUtils.makeCollection(employeeDAO.readAll2());
            for (Employee found : employeeList) {
                TestUtils.reassure(found);
            }
            pureJdbc[i] = System.nanoTime() - start;
        }
        double springJdbcAvg = MathsUtils.avg(springJdbc);
        double pureJdbcAvg = MathsUtils.avg(pureJdbc);
        LOG.log(Level.INFO, "springJdbc {0} {1} {2}", new Object[]{springJdbcAvg, MathsUtils.PLUS_MINUS_SIGN, MathsUtils.sd(springJdbc, springJdbcAvg)});
        LOG.log(Level.INFO, "pureJdbc {0} {1} {2}", new Object[]{pureJdbcAvg, MathsUtils.PLUS_MINUS_SIGN, MathsUtils.sd(pureJdbc, pureJdbcAvg)});
    }
}
