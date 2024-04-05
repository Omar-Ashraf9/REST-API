package gov.iti.jets.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "departmentName", length = 45)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    private Employee manager;

    @Column(name = "managerStartDate")
    private Date managerStartDate;

    @Transient
    private String managerName;
    @PostLoad
    public void setManagerName(){
        if(manager != null){
            managerName = manager.getFirstName() + " " + manager.getLastName();
        }
    }
}