package org.dummy.roster.backend.rest;

import java.util.List;
import org.dummy.roster.backend.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.entity.Employee;
import static org.dummy.roster.backend.utils.Constants.API_V1_EMPLOYEES;


/**
 * Контроллер.
 */
@CrossOrigin
@RestController
@RequestMapping(API_V1_EMPLOYEES)
public class RosterRestController {

    private final EmployeeRepository employeeRepository;

    public RosterRestController(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> readAll() {
        return new ResponseEntity<>((List<Employee>) employeeRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Создать {@link Employee}.
     * @param employee создаваемый {@link Employee}
     * @return созданный {@link Employee}
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>((Employee) employeeRepository.save(employee), HttpStatus.CREATED);
    }

    /**
     * Изменить {@link Employee}.
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee employee) {
        return new ResponseEntity<>((Employee) employeeRepository.save(employee), HttpStatus.OK);
    }

    /**
     * Удалить всех {@link Employee}.
     * @return {@link ResponseEntity}
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        employeeRepository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

}
