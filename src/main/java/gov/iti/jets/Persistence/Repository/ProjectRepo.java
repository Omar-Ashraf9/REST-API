package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Project;
import jakarta.persistence.EntityManager;

public class ProjectRepo extends GenericRepo<Project, Integer>{
    public ProjectRepo(EntityManager entityManager) { super(Project.class, entityManager); }
}
