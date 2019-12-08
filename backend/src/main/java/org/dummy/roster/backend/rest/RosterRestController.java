package org.dummy.roster.backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.service.RosterService;

/**
 * Контроллер.
 */
@RestController
@RequestMapping("/employees")
public class RosterRestController {

    @Autowired
    RosterService rosterService;

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> readAll() {
        return new ResponseEntity(rosterService.findAll(), HttpStatus.OK);
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

}
