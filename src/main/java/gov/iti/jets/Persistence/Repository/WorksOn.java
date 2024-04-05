package gov.iti.jets.Persistence.Repository;

import jakarta.persistence.EntityManager;

public class WorksOn extends GenericRepo<WorksOn, Integer>{
    public WorksOn(EntityManager entityManager) { super(WorksOn.class, entityManager); }
}
