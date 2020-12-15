package org.dummy.roster.backend.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.dao.EmployeeDAO;
import org.dummy.roster.backend.entity.Employee;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;


/**
 * Контроллер.
 */
@RestController
@RequestMapping(API_V1_EMPLOYEES)
@CrossOrigin
@Validated
public class RosterRestController {

    private final EmployeeDAO employeeDAO;

    public RosterRestController(EmployeeDAO d) {
        this.employeeDAO = d;
    }

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @GetMapping
    List<Employee> readAll() {
        return (List<Employee>) employeeDAO.readAll();
    }

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @GetMapping(value = "/compare")
    String compare() {
        return employeeDAO.compare();
    }

    /**
     * Создать {@link Employee}.
     * @param employee создаваемый {@link Employee}
     * @return созданный {@link Employee}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee create(@RequestBody Employee employee) {
        return employeeDAO.create(employee);
    }

    /**
     * Изменить {@link Employee}.
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    @PutMapping("/{id}")
    Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeDAO.update(employee);
    }

    /**
     * Удалить всех {@link Employee}.
     * @return {@link ResponseEntity}
     */
    @DeleteMapping
    void deleteAll() {
        employeeDAO.deleteAll();
    }

}
