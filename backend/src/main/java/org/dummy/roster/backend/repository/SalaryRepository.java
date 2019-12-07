package org.dummy.roster.backend.repository;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.dummy.roster.backend.entity.Salary;

@Repository
public interface SalaryRepository extends PagingAndSortingRepository<Salary, UUID> {
}
