package gov.iti.jets.Persistence.Repository;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Persistence.Entities.Job;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JobRepo extends GenericRepo<Job, Integer>{
    public JobRepo(EntityManager entityManager) { super(Job.class, entityManager); }
    public Optional<List<Job>> searchJobs(String jobTitle) {
        return Optional.ofNullable(entityManager.createQuery("SELECT j FROM Job j WHERE j.jobTitle LIKE :jobTitle", Job.class)
                .setParameter("jobTitle", "%" + jobTitle + "%")
                .getResultList());
    }
}
