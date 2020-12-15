package org.dummy.roster.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.dummy.roster.backend.rest.RosterRestController;
import org.dummy.roster.backend.dao.EmployeeDAO;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;
import static org.dummy.roster.backend.RestUtils.buildPost;
import static org.dummy.roster.backend.TestUtils.makeDummyEmployeeE;

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
     * {@link EmployeeERepository}.
     */
    @MockBean
    private EmployeeERepository employeeRepository;

    /**
     * {@link EmployeeDAO}.
     */
    @MockBean
    private EmployeeDAO employeeDAO;

    @Test
    public void saveTest() {
        try {
            mvc.perform(buildPost(API_V1_EMPLOYEES, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, makeDummyEmployeeE())).andExpect(status().isCreated());
        } catch (Exception e) {

        }
    }
}
