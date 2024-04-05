package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Persistence.Entities.Job;
import jakarta.persistence.EntityManager;

public class JobRepo extends GenericRepo<Job, Integer>{
    public JobRepo(EntityManager entityManager) { super(Job.class, entityManager); }
}
