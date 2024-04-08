package gov.iti.jets;

import gov.iti.jets.Persistence.Entities.Project;
import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Entities.WorksOn;
import gov.iti.jets.Persistence.Entities.WorksOnId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DBpopulator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
