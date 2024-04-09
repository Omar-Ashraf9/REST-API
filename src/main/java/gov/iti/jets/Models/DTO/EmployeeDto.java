package gov.iti.jets.Models.DTO;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Employee}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonbPropertyOrder({"id", "firstName", "lastName", "birthDate", "address", "gender", "salary",
        "age", "vacationBalance", "managerName", "departmentName", "jobTitle"})
public class EmployeeDto implements Serializable {
    Integer id;
    @Size(max = 50)
    String firstName;
    @Size(max = 50)
    String lastName;
    @JsonbDateFormat("yyyy-MM-dd")
    LocalDate birthDate;
    @Size(max = 100)
    String address;
    @Size(max = 45)
    String gender;
    BigDecimal salary;
    Integer age;
    Integer vacationBalance;
    String managerName;
    String departmentName;
    String jobTitle;
    Integer managerId;
    Integer departmentId;
    Integer jobId;
}