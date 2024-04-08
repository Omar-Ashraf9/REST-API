package gov.iti.jets;

import gov.iti.jets.Persistence.Entities.Job;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class DBpopulator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Job job1 = new Job();
        job1.setId(1);
        job1.setJobTitle("Software Engineer");
        job1.setMinSalary(new BigDecimal("3000.00"));
        job1.setMaxSalary(new BigDecimal("5000.00"));

        Job job2 = new Job();
        job2.setId(2);
        job2.setJobTitle("Data Analyst");
        job2.setMinSalary(new BigDecimal("3500.00"));
        job2.setMaxSalary(new BigDecimal("5500.00"));

        Job job3 = new Job();
        job3.setId(3);
        job3.setJobTitle("Project Manager");
        job3.setMinSalary(new BigDecimal("4000.00"));
        job3.setMaxSalary(new BigDecimal("6000.00"));

        Job job4 = new Job();
        job4.setId(4);
        job4.setJobTitle("System Analyst");
        job4.setMinSalary(new BigDecimal("4500.00"));
        job4.setMaxSalary(new BigDecimal("6500.00"));

        em.persist(job1);
        em.persist(job2);
        em.persist(job3);
        em.persist(job4);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
