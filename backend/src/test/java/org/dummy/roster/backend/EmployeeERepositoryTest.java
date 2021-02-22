package org.dummy.roster.backend;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dummy.roster.backend.repo.EmployeeERepository;
import org.dummy.roster.backend.utils.CollectionUtils;
import org.dummy.roster.backend.utils.MathsUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.dummy.roster.backend.entity.EmployeeE;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
public class EmployeeERepositoryTest {

    private static final Logger LOG = Logger.getLogger(EmployeeERepositoryTest.class.getSimpleName());

    /**
     * {@link EmployeeERepository}.
     */
    @Autowired
    private EmployeeERepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository.save(TestUtils.DUMMY_EMPLOYEE_E);
    }

    @After
    public void tearDown() {
        employeeRepository.delete(TestUtils.DUMMY_EMPLOYEE_E);
        assertFalse("employee deleted", employeeRepository.findById(TestUtils.DUMMY_EMPLOYEE_E.getId()).isPresent());
    }

    /**
     * {@link Test} {@link EmployeeERepository#findById(Object)}.
     */
    @SuppressWarnings("java:S2699")
    @Test
    public void readTest() {
        EmployeeE found = employeeRepository.findById(TestUtils.DUMMY_EMPLOYEE_E.getId()).get();
        TestUtils.reassureE(found);
    }

    @SuppressWarnings("java:S2699")
    @Test
    public void selectComparison() {
        long[] jpa = new long[MathsUtils.SAMPLE_SIZE];
        long start;
        for (int i = 0; i < MathsUtils.SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            List<EmployeeE> employeeeList = (List<EmployeeE>) CollectionUtils.makeCollection(employeeRepository.findAll());
            for (EmployeeE found : employeeeList) {
                TestUtils.reassureE(found);
            }
            jpa[i] = System.nanoTime() - start;
        }
        double jpaAvg = MathsUtils.avg(jpa);
        LOG.log(Level.INFO, "jpa {0} {1} {2}", new Object[]{jpaAvg, MathsUtils.PLUS_MINUS_SIGN, MathsUtils.sd(jpa, jpaAvg)});
    }
}
