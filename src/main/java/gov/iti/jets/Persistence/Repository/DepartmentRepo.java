package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Department;
import jakarta.persistence.EntityManager;

public class DepartmentRepo extends GenericRepo<Department, Integer>{

    public DepartmentRepo(EntityManager entityManager) { super(Department.class, entityManager); }
}
