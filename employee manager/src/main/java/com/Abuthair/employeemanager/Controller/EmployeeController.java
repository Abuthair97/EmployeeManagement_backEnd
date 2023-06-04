package com.Abuthair.employeemanager.Controller;

import com.Abuthair.employeemanager.model.Employee;
import com.Abuthair.employeemanager.service.IEmployeeService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;

/**
 * @author abuthair on 04/06/23.
 * 12:34 pm
 * @project employee manager
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
     private IEmployeeService iEmployeeService;
    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc" ," Getting All Employee");
        ResponseEntity responseEntity = new ResponseEntity<>(employeeList, headers,HttpStatus.OK );
        return responseEntity;


    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee  employee1 = iEmployeeService.addEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Employee has been added");
        ResponseEntity responseEntity = new ResponseEntity<>(employee1,headers,HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/updated")
    public ResponseEntity<Employee> updateEmployee(Employee employee){
        Employee employee1 = iEmployeeService.updateEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc"," the employee details Has been Updated");
        ResponseEntity responseEntity = new ResponseEntity<>(employee1,headers,HttpStatus.ACCEPTED);
       return responseEntity;
    }

  @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") Long id){
      Employee employee = iEmployeeService.getEmployeeById( id);
      HttpHeaders headers = new HttpHeaders();
      headers.add("desc","Found Employee By"+id);
      ResponseEntity responseEntity = new ResponseEntity<>(employee,headers,HttpStatus.OK);
      return  responseEntity;
  }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmoloyee(@PathVariable("id") Long id) {
        Employee employee = iEmployeeService.deleteEmoloyee(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Desc","Employee with This "+id+" has been deleted" );
        ResponseEntity responseEntity = new ResponseEntity<>(employee,headers,HttpStatus.OK);
        return responseEntity;
    }

}
