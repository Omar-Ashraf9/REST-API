package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeRepo extends GenericRepo<Employee, Integer>{

        public EmployeeRepo(EntityManager entityManager) { super(Employee.class, entityManager); }
}
