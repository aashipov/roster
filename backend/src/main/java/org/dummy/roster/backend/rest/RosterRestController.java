package org.dummy.roster.backend.rest;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.entity.Employee;
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
     * Обновить {@link Employee}.
     * @param id ID
     * @param employee  {@link Employee}
     * @return обновлённый {@link Employee}
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee employee) {
        if (null != id) {
            employee.setId(UUID.fromString(id));
        } else {
            throw new IllegalArgumentException("id is null");
        }
        return new ResponseEntity<>(rosterService.save(employee), HttpStatus.OK);
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
