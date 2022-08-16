package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
