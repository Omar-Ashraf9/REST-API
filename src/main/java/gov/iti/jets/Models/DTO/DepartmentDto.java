package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Department}
 */
@Value
public class DepartmentDto implements Serializable {
    Integer id;
    @Size(max = 45)
    String departmentName;
    LocalDate managerStartDate;
}