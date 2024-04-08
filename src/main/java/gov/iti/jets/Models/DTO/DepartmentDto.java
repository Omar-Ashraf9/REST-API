package gov.iti.jets.Models.DTO;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Department}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {
    Integer id;
    @Size(max = 45)
    String departmentName;
    @JsonbDateFormat("yyyy-MM-dd")
    LocalDate managerStartDate;
    String managerName;
    Integer managerId;
    boolean available = true;
}