package com.mka.employeeProject.rest;

import com.mka.employeeProject.entity.Employee;
import com.mka.employeeProject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeService employeeService;

  public EmployeeRestController(EmployeeService empService) {
    this.employeeService = empService;
  }

  @GetMapping("/employees")
  public List<Employee> findAllEmployees() {
    return employeeService.findAllEmployees();
  }

  @GetMapping("/employees/{employeeId}")
  public ResponseEntity<Employee> findEmployeeById(@PathVariable Long employeeId) {
    Employee employee = employeeService.findEmployeeById(employeeId);
    return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
  }

  @PostMapping("/employees")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    employeeService.createEmployee(employee);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }

  @PutMapping("/employees/{employeeId}")
  public ResponseEntity<Employee> updateEmployee(
    @PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
    Employee existingEmployee = employeeService.findEmployeeById(employeeId);
    if (existingEmployee == null) {
      return ResponseEntity.notFound().build();
    }
    updatedEmployee.setId(employeeId); // Ensure the ID remains the same
    Employee savedEmployee = employeeService.updateEmployee(updatedEmployee);
    return ResponseEntity.ok(savedEmployee);
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    Employee employee = employeeService.findEmployeeById(id);
    if (employee == null) {
      return ResponseEntity.notFound().build();
    }
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
 }

















