package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Job}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String jobTitle;
    BigDecimal minSalary;
    BigDecimal maxSalary;
    boolean available = true;
}