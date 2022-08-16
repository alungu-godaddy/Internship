package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDaoJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Query query =
                entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
