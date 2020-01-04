package org.dummy.roster.backend;

import org.dummy.roster.backend.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.dummy.roster.backend.rest.RosterRestController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;
import static org.dummy.roster.backend.RestUtils.buildPost;
import static org.dummy.roster.backend.TestUtils.makeADummy;

/**
 * Тест {@link RosterRestController}.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RosterRestController.class)
public class RosterRestControllerTest {

    /**
     * {@link MockMvc}.
     */
    @Autowired
    private MockMvc mvc;

    /**
     * {@link EmployeeRepository}.
     */
    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void saveTest() {
        try {
            mvc.perform(buildPost(API_V1_EMPLOYEES, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, makeADummy())).andExpect(status().isCreated());
        } catch (Exception e) {

        }
    }
}
