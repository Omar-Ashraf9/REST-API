package gov.iti.jets.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "jobId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    @Column(name = "jobTitle", unique = true)
    private String jobTitle;

    @Column(name = "minSalary", precision = 10, scale = 2)
    private BigDecimal minSalary;

    @Column(name = "maxSalary", precision = 10, scale = 2)
    private BigDecimal maxSalary;

    @Column(name = "isAvailable")
    private boolean isAvailable;

}