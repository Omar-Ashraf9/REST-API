package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class EmployeeRepo extends GenericRepo<Employee, Integer>{

        public EmployeeRepo(EntityManager entityManager) { super(Employee.class, entityManager); }

        public Optional<List<Employee>> findManagers() {
                return Optional.ofNullable(entityManager.createQuery("SELECT e FROM Employee e WHERE e.id IN (SELECT m.manager.id FROM Employee m)", Employee.class)
                        .getResultList());
        }
}
