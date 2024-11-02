package com.mka.employeeProject.dao;

import com.mka.employeeProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
  List<Employee> findAllEmployees();
}
