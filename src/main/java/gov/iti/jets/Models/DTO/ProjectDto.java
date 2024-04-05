package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Project}
 */
@Value
public class ProjectDto implements Serializable {
    Integer id;
    @Size(max = 45)
    String projectName;
    DepartmentDto department;
}