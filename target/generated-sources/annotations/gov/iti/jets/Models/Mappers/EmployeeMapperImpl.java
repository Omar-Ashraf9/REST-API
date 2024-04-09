package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Persistence.Entities.Employee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T06:11:42+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setFirstName( employeeDto.getFirstName() );
        employee.setLastName( employeeDto.getLastName() );
        if ( employeeDto.getBirthDate() != null ) {
            employee.setBirthDate( Date.from( employeeDto.getBirthDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        employee.setAddress( employeeDto.getAddress() );
        employee.setGender( employeeDto.getGender() );
        employee.setSalary( employeeDto.getSalary() );
        employee.setAge( employeeDto.getAge() );
        employee.setVacationBalance( employeeDto.getVacationBalance() );
        employee.setManagerName( employeeDto.getManagerName() );
        employee.setDepartmentName( employeeDto.getDepartmentName() );
        employee.setJobTitle( employeeDto.getJobTitle() );

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        Integer id = null;
        String firstName = null;
        String lastName = null;
        LocalDate birthDate = null;
        String address = null;
        String gender = null;
        BigDecimal salary = null;
        Integer age = null;
        Integer vacationBalance = null;
        String managerName = null;
        String departmentName = null;
        String jobTitle = null;

        id = employee.getId();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        if ( employee.getBirthDate() != null ) {
            birthDate = LocalDateTime.ofInstant( employee.getBirthDate().toInstant(), ZoneOffset.UTC ).toLocalDate();
        }
        address = employee.getAddress();
        gender = employee.getGender();
        salary = employee.getSalary();
        age = employee.getAge();
        vacationBalance = employee.getVacationBalance();
        managerName = employee.getManagerName();
        departmentName = employee.getDepartmentName();
        jobTitle = employee.getJobTitle();

        EmployeeDto employeeDto = new EmployeeDto( id, firstName, lastName, birthDate, address, gender, salary, age, vacationBalance, managerName, departmentName, jobTitle );

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> toDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public Employee partialUpdate(EmployeeDto employeeDto, Employee employee) {
        if ( employeeDto == null ) {
            return employee;
        }

        if ( employeeDto.getId() != null ) {
            employee.setId( employeeDto.getId() );
        }
        if ( employeeDto.getFirstName() != null ) {
            employee.setFirstName( employeeDto.getFirstName() );
        }
        if ( employeeDto.getLastName() != null ) {
            employee.setLastName( employeeDto.getLastName() );
        }
        if ( employeeDto.getBirthDate() != null ) {
            employee.setBirthDate( Date.from( employeeDto.getBirthDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        if ( employeeDto.getAddress() != null ) {
            employee.setAddress( employeeDto.getAddress() );
        }
        if ( employeeDto.getGender() != null ) {
            employee.setGender( employeeDto.getGender() );
        }
        if ( employeeDto.getSalary() != null ) {
            employee.setSalary( employeeDto.getSalary() );
        }
        if ( employeeDto.getAge() != null ) {
            employee.setAge( employeeDto.getAge() );
        }
        if ( employeeDto.getVacationBalance() != null ) {
            employee.setVacationBalance( employeeDto.getVacationBalance() );
        }
        if ( employeeDto.getManagerName() != null ) {
            employee.setManagerName( employeeDto.getManagerName() );
        }
        if ( employeeDto.getDepartmentName() != null ) {
            employee.setDepartmentName( employeeDto.getDepartmentName() );
        }
        if ( employeeDto.getJobTitle() != null ) {
            employee.setJobTitle( employeeDto.getJobTitle() );
        }

        return employee;
    }
}
