package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Entities.Project;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class EmployeeRepo extends GenericRepo<Employee, Integer>{

        public EmployeeRepo(EntityManager entityManager) { super(Employee.class, entityManager); }

        public Optional<List<Employee>> findManagers() {
                return Optional.ofNullable(entityManager.createQuery("SELECT e FROM Employee e WHERE e.id IN (SELECT m.manager.id FROM Employee m)", Employee.class)
                        .getResultList());
        }

        public boolean isManager(Employee employee) {
                return entityManager.createQuery("SELECT e FROM Employee e WHERE e.id IN (SELECT m.manager.id FROM Employee m)", Employee.class)
                        .getResultList().contains(employee);
        }

        public Optional<List<Project>> getProjects(Integer employeeId) {
                return Optional.ofNullable(entityManager.createQuery("SELECT p FROM Project p WHERE p.id IN (SELECT w.project.id FROM WorksOn w WHERE w.employee.id = :employeeId)", Project.class)
                        .setParameter("employeeId", employeeId)
                        .getResultList());
        }
}
