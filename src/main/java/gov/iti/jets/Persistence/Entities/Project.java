package gov.iti.jets.Persistence.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "projectId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 45)
    @Column(name = "projectName", length = 45)
    private String projectName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Transient
    private String departmentName;

    @Transient
    private Integer departmentId;

    @PostLoad
    public void setDepartmentInfo(){
        if(department != null)
        {
            departmentName = department.getDepartmentName();
            departmentId = department.getId();
        }

    }
}