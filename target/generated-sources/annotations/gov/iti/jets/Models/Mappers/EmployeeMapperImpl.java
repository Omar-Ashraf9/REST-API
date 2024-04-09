package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Persistence.Entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T21:16:10+0200",
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
        employee.setBirthDate( employeeDto.getBirthDate() );
        employee.setAddress( employeeDto.getAddress() );
        employee.setGender( employeeDto.getGender() );
        employee.setSalary( employeeDto.getSalary() );
        employee.setAge( employeeDto.getAge() );
        employee.setVacationBalance( employeeDto.getVacationBalance() );
        employee.setManagerName( employeeDto.getManagerName() );
        employee.setDepartmentName( employeeDto.getDepartmentName() );
        employee.setJobTitle( employeeDto.getJobTitle() );
        employee.setManagerId( employeeDto.getManagerId() );
        employee.setDepartmentId( employeeDto.getDepartmentId() );
        employee.setJobId( employeeDto.getJobId() );

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setFirstName( employee.getFirstName() );
        employeeDto.setLastName( employee.getLastName() );
        employeeDto.setBirthDate( employee.getBirthDate() );
        employeeDto.setAddress( employee.getAddress() );
        employeeDto.setGender( employee.getGender() );
        employeeDto.setSalary( employee.getSalary() );
        employeeDto.setAge( employee.getAge() );
        employeeDto.setVacationBalance( employee.getVacationBalance() );
        employeeDto.setManagerName( employee.getManagerName() );
        employeeDto.setDepartmentName( employee.getDepartmentName() );
        employeeDto.setJobTitle( employee.getJobTitle() );
        employeeDto.setManagerId( employee.getManagerId() );
        employeeDto.setDepartmentId( employee.getDepartmentId() );
        employeeDto.setJobId( employee.getJobId() );

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
            employee.setBirthDate( employeeDto.getBirthDate() );
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
        if ( employeeDto.getManagerId() != null ) {
            employee.setManagerId( employeeDto.getManagerId() );
        }
        if ( employeeDto.getDepartmentId() != null ) {
            employee.setDepartmentId( employeeDto.getDepartmentId() );
        }
        if ( employeeDto.getJobId() != null ) {
            employee.setJobId( employeeDto.getJobId() );
        }

        return employee;
    }
}
