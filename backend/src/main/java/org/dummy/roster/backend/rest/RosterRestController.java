package org.dummy.roster.backend.rest;

import java.math.BigDecimal;
import java.util.List;
import org.dummy.roster.backend.repo.EmployeeERepository;
import org.dummy.roster.backend.utils.MathsUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.dummy.roster.backend.dao.EmployeeDAO;
import org.dummy.roster.backend.dto.Employee;

import static org.dummy.roster.backend.utils.CollectionUtils.makeCollection;
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
    private final EmployeeERepository employeeERepository;

    public RosterRestController(EmployeeDAO d, EmployeeERepository r) {
        this.employeeDAO = d;
        this.employeeERepository = r;
    }

    private String springDataReadStats() {
        long[] springData = new long[MathsUtils.SAMPLE_SIZE];
        int[] springDataCount = new int[MathsUtils.SAMPLE_SIZE];
        long start;
        for (int i = 0; i < MathsUtils.SAMPLE_SIZE; i++) {
            start = System.nanoTime();
            springDataCount[i] = makeCollection(employeeERepository.findAll()).size();
            springData[i] = System.nanoTime() - start;
        }
        Assert.isTrue(springDataCount[MathsUtils.SAMPLE_SIZE - 1] > 0, "");
        double jpaAvg = MathsUtils.avg(springData);
        return "spring data " + BigDecimal.valueOf(jpaAvg) + MathsUtils.PLUS_MINUS_SIGN + BigDecimal.valueOf(MathsUtils.sd(springData, jpaAvg));
    }

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @GetMapping
    public List<Employee> readAll() {
        return employeeDAO.readAll();
    }

    /**
     * Получить всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    @GetMapping(value = "/compare")
    public String compare() {
        return employeeDAO.compare() + "\n" + this.springDataReadStats();
    }

    /**
     * Создать {@link Employee}.
     * @param employee создаваемый {@link Employee}
     * @return созданный {@link Employee}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeDAO.create(employee);
    }

    /**
     * Изменить {@link Employee}.
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeDAO.update(employee);
    }

    /**
     * Удалить всех {@link Employee}.
     * @return {@link ResponseEntity}
     */
    @DeleteMapping
    public void deleteAll() {
        employeeDAO.deleteAll();
    }

}
