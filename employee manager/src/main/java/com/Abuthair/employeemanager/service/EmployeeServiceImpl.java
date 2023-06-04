package com.Abuthair.employeemanager.service;

import com.Abuthair.employeemanager.exception.UserNotFoundException;
import com.Abuthair.employeemanager.model.Employee;
import com.Abuthair.employeemanager.repository.iEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author abuthair on 04/06/23.
 * 12:09 pm
 * @project employee manager
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    iEmployeeRepository  iemployeeRepository;
    @Autowired
    public EmployeeServiceImpl(iEmployeeRepository iemployeeRepository) {
        this.iemployeeRepository = iemployeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return iemployeeRepository.save(employee);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return iemployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return iemployeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws UserNotFoundException {
      Employee employees =   iemployeeRepository.findById(id).get();
     if(employees == null){
         throw new UserNotFoundException("Employee Not Found with "+id);
     }
        return employees;
    }


    @Override
    public Employee deleteEmoloyee(Long id) {
    iemployeeRepository.deleteById(id);
        return null;
    }
}
