package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Project}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto implements Serializable {
    Integer id;
    @Size(max = 45)
    String projectName;
    String departmentName;
    Integer departmentId;
    boolean available = true;
}