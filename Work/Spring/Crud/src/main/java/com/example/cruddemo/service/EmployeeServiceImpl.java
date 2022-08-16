package com.example.cruddemo.service;

import com.example.cruddemo.data.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Did not find employee id of - " + id);
        }

        return result.get();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
