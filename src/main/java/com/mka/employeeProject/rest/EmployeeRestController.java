package com.mka.employeeProject.rest;

import com.mka.employeeProject.dao.EmployeeDAO;
import com.mka.employeeProject.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeDAO employeeDAO;

  public EmployeeRestController(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @GetMapping("/employees")
  public List<Employee> findAllEmployees() {
    return employeeDAO.findAllEmployees();
  }

}
