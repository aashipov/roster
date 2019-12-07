package org.dummy.roster.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.service.RosterService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class RosterRestController {

    @Autowired
    RosterService rosterService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> readAll() {
        return new ResponseEntity(rosterService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save_kludge")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(rosterService.saveKludge(employee), HttpStatus.CREATED);
    }

}
