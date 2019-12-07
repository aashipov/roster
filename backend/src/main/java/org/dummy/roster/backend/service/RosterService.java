package org.dummy.roster.backend.service;

import java.util.List;
import org.dummy.roster.backend.entity.Employee;
import org.dummy.roster.backend.entity.Salary;

/**
 * Сервис {@link Employee}.
 * @param <E> {@link Employee}
 * @param <S> {@link Salary}
 */
public interface RosterService<E extends Employee, S extends Salary> {

    /**
     * Сохранить {@link Employee}.
     * @param employee {@link Employee}
     * @return {@link Employee}
     */
    E saveKludge(E employee);

    /**
     * Прочитать всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    List<E> findAll();
}
