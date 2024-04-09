package gov.iti.jets.Models.DTO;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO for {@link gov.iti.jets.Persistence.Entities.Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Integer id;
    @Size(max = 50)
    String firstName;
    @Size(max = 50)
    String lastName;
    Date birthDate;
    @Size(max = 100)
    String address;
    @Size(max = 45)
    String gender;
    BigDecimal salary;
    DepartmentDto department;
    Integer age;
    Integer vacationBalance;
    JobDto job;
    String managerName;
    String departmentName;
    String jobTitle;
}