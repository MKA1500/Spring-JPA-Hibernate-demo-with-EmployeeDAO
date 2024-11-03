package com.mka.employeeProject.dao;

import com.mka.employeeProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAllEmployees() {
    TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
    List<Employee> employees = theQuery.getResultList();
    return employees;
  }

  @Override
  public Employee findEmployeeById(Long id) {
    Employee theEmployee = entityManager.find(Employee.class, id);
    return theEmployee;
  }

  @Override
  public void createEmployee(Employee employee) {
    entityManager.persist(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    // if id of entity is null, merge will work like create,
    // but  for creating the persist method is more efficient
    Employee savedEmployee = entityManager.merge(employee);
    return savedEmployee;
  }

  @Override
  public void deleteEmployee(Long id) {
    Employee theEmployee = entityManager.find(Employee.class, id);
    entityManager.remove(theEmployee);
  }
}
