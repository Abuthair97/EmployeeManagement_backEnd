package com.Abuthair.employeemanager.service;

import com.Abuthair.employeemanager.model.Employee;

import java.util.List;

/**
 * @author abuthair on 04/06/23.
 * 12:07 pm
 * @project employee manager
 */
public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee deleteEmoloyee(Long id);

}
