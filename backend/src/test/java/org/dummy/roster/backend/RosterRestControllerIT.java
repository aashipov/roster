package org.dummy.roster.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.dummy.roster.backend.RestUtils.buildPost;
import static org.dummy.roster.backend.TestUtils.makeADummy;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;

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
     * {@link EmployeeERepository}.
     */
    @Autowired
    private EmployeeERepository employeeRepository;

    @Test
    public void saveTest() {
        try {
            mvc.perform(buildPost(API_V1_EMPLOYEES, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, makeADummy()))
                    .andExpect(status().isCreated());
        } catch (Exception e) {

        }
    }
}
