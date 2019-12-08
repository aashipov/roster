package org.dummy.roster.backend;

import org.dummy.roster.backend.repository.EmployeeRepository;
import org.dummy.roster.backend.repository.SalaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.dummy.roster.backend.RestUtils.buildPost;
import static org.dummy.roster.backend.TestUtils.makeADummy;
import static org.dummy.roster.backend.rest.RosterRestController.ROSTER_PATH;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test {@link org.dummy.roster.backend.rest.RosterRestController}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:integration-test.properties")
public class RosterRestControllerIT {

    /**
     * {@link MockMvc}.
     */
    @Autowired
    private MockMvc mvc;

    /**
     * {@link EmployeeRepository}.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * {@link SalaryRepository}.
     */
    @Autowired
    private SalaryRepository salaryRepository;

    @Test
    public void saveTest() {
        try {
            mvc.perform(buildPost(ROSTER_PATH, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, makeADummy()))
                    .andExpect(status().isCreated());
        } catch (Exception e) {

        }
    }
}
