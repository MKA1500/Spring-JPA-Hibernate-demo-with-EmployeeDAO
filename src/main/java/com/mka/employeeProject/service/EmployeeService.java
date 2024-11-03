package com.mka.employeeProject.service;

import com.mka.employeeProject.entity.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAllEmployees();

  Employee findEmployeeById(Long id);

  void createEmployee(Employee employee);

  Employee updateEmployee(Employee employee);

  void deleteEmployee(Long id);
}
