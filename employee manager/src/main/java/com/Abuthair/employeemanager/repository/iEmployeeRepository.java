package com.Abuthair.employeemanager.repository;

import com.Abuthair.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abuthair on 04/06/23.
 * 12:03 pm
 * @project employee manager
 */
@Repository
public interface iEmployeeRepository extends JpaRepository<Employee,Long> {


}
