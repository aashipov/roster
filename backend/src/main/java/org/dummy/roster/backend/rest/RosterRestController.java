package org.dummy.roster.backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.repository.EmployeeRepository;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;


/**
 * Контроллер.
 */
@RestController
@RequestMapping(API_V1_EMPLOYEES)
@CrossOrigin
@Validated
public class RosterRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @GetMapping
    List<Employee> readAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    /**
     * Создать {@link Employee}.
     * @param employee создаваемый {@link Employee}
     * @return созданный {@link Employee}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee create(@RequestBody Employee employee) {
        return (Employee) employeeRepository.save(employee);
    }

    /**
     * Изменить {@link Employee}.
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    @PutMapping("/{id}")
    Employee update(@PathVariable String id, @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Удалить всех {@link Employee}.
     * @return {@link ResponseEntity}
     */
    @DeleteMapping
    void deleteAll() {
        employeeRepository.deleteAll();
    }

}
