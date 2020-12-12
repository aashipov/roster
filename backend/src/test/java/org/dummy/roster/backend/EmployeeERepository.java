package org.dummy.roster.backend;

import org.dummy.roster.backend.entity.EmployeeE;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Repository} {@link EmployeeE}.
 */
@Repository
public interface EmployeeERepository extends PagingAndSortingRepository<EmployeeE, Long> {
}
