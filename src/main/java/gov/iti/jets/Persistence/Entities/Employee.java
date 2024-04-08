package gov.iti.jets.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "firstName", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "birthDate")
    private Date birthDate;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(max = 45)
    @Column(name = "gender", length = 45)
    private String gender;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;

    @Column(name = "age")
    private Integer age;

    @Column(name = "vacationBalance")
    private Integer vacationBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    private Job job;

    @Transient
    private String managerName;

    @PostLoad
    public void setManagerInfo(){
        if(manager != null){
            managerName = manager.getFirstName() + " " + manager.getLastName();
        }
    }
}