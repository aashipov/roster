package org.dummy.roster.backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;
import org.dummy.roster.backend.service.RosterService;

/**
 * Контроллер.
 */
@RestController
@RequestMapping(RosterRestController.ROSTER_PATH)
public class RosterRestController {

    public static final String ROSTER_PATH = "/employees";

    @Autowired
    RosterService rosterService;

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> readAll() {
        return new ResponseEntity<>(rosterService.findAll(), HttpStatus.OK);
    }

    /**
     * Создать {@link Employee}.
     * @param employee создаваемый {@link Employee}
     * @return созданный {@link Employee}
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(rosterService.save(employee), HttpStatus.CREATED);
    }

    /**
     * Изменить {@link Salary}.
     * @param salary {@link Salary}
     * @return {@link Salary}
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/change_salary")
    public ResponseEntity<Salary> changeSalary(@RequestBody Salary salary) {
        return new ResponseEntity<>(rosterService.changeSalary(salary), HttpStatus.OK);
    }

    /**
     * Удалить всех {@link Employee}.
     * @return {@link ResponseEntity}
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete_all")
    public ResponseEntity deleteAll() {
        rosterService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

}
