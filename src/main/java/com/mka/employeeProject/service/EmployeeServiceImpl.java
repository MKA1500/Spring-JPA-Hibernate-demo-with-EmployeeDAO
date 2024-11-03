package com.mka.employeeProject.service;

import com.mka.employeeProject.dao.EmployeeDAO;
import com.mka.employeeProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Employee> findAllEmployees() {
    return employeeDAO.findAllEmployees();
  }

  @Override
  @Transactional(readOnly = true)
  public Employee findEmployeeById(Long id) {
    return employeeDAO.findEmployeeById(id);
  }

  @Override
  @Transactional
  public void createEmployee(Employee employee) {
    employeeDAO.createEmployee(employee);
  }

  @Override
  @Transactional
  public Employee updateEmployee(Employee employee) {
    return employeeDAO.updateEmployee(employee);
  }

  @Override
  @Transactional
  public void deleteEmployee(Long id) {
    employeeDAO.deleteEmployee(id);
  }
}
