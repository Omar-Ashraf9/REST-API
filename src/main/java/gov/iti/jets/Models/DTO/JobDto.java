package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Job}
 */
@Value
public class JobDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String jobTitle;
    BigDecimal minSalary;
    BigDecimal maxSalary;
}