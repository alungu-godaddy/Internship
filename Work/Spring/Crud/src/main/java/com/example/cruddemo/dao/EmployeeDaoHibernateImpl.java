package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // repository - provides mechanism for crud operations -- extends @Component
@AllArgsConstructor // automatically uses constructor injection
public class EmployeeDaoHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Override
    // @Transactional // execute method in a transaction -- automatically starts and commits transaction
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Employee> query =
                currentSession.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session currentSession =
                entityManager.unwrap(Session.class);

        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Session currentSession =
                entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee); // if id = 0 -> insert, else update
    }

    @Override
    public void deleteById(int id) {
        Session currentSession =
                entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery(
                "delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
