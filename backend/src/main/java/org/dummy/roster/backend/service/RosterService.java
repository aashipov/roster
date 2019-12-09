package org.dummy.roster.backend.service;

import java.util.List;
import java.util.UUID;
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
    E save(E employee);

    /**
     * Прочитать всех {@link Employee}.
     * @return {@link List} {@link Employee}
     */
    List<E> findAll();

    /**
     * Найти {@link Employee} по {@link UUID}.
     * @param uuid {@link UUID}
     * @return {@link Employee}
     */
    E findById(UUID uuid);

    /**
     * Удалить всех {@link Employee}.
     */
    void deleteAll();

    /**
     * Изменить {@link Salary} {@link Employee}.
     * @param salary {@link Salary}
     * @return {@link Employee}
     */
    S changeSalary(Salary salary);
}
