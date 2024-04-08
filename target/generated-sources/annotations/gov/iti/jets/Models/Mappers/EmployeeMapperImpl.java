package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Persistence.Entities.Department;
import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Entities.Job;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T15:43:52+0200",
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
        employee.setDepartment( departmentDtoToDepartment( employeeDto.getDepartment() ) );
        employee.setAge( employeeDto.getAge() );
        employee.setVacationBalance( employeeDto.getVacationBalance() );
        employee.setJob( jobDtoToJob( employeeDto.getJob() ) );
        employee.setManagerName( employeeDto.getManagerName() );

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
        Date birthDate = null;
        String address = null;
        String gender = null;
        BigDecimal salary = null;
        DepartmentDto department = null;
        Integer age = null;
        Integer vacationBalance = null;
        JobDto job = null;
        String managerName = null;

        id = employee.getId();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        birthDate = employee.getBirthDate();
        address = employee.getAddress();
        gender = employee.getGender();
        salary = employee.getSalary();
        department = departmentToDepartmentDto( employee.getDepartment() );
        age = employee.getAge();
        vacationBalance = employee.getVacationBalance();
        job = jobToJobDto( employee.getJob() );
        managerName = employee.getManagerName();

        EmployeeDto employeeDto = new EmployeeDto( id, firstName, lastName, birthDate, address, gender, salary, department, age, vacationBalance, job, managerName );

        return employeeDto;
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
        if ( employeeDto.getDepartment() != null ) {
            if ( employee.getDepartment() == null ) {
                employee.setDepartment( new Department() );
            }
            departmentDtoToDepartment1( employeeDto.getDepartment(), employee.getDepartment() );
        }
        if ( employeeDto.getAge() != null ) {
            employee.setAge( employeeDto.getAge() );
        }
        if ( employeeDto.getVacationBalance() != null ) {
            employee.setVacationBalance( employeeDto.getVacationBalance() );
        }
        if ( employeeDto.getJob() != null ) {
            if ( employee.getJob() == null ) {
                employee.setJob( new Job() );
            }
            jobDtoToJob1( employeeDto.getJob(), employee.getJob() );
        }
        if ( employeeDto.getManagerName() != null ) {
            employee.setManagerName( employeeDto.getManagerName() );
        }

        return employee;
    }

    protected Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setDepartmentName( departmentDto.getDepartmentName() );
        if ( departmentDto.getManagerStartDate() != null ) {
            department.setManagerStartDate( Date.from( departmentDto.getManagerStartDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }

        return department;
    }

    protected Job jobDtoToJob(JobDto jobDto) {
        if ( jobDto == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( jobDto.getId() );
        job.setJobTitle( jobDto.getJobTitle() );
        job.setMinSalary( jobDto.getMinSalary() );
        job.setMaxSalary( jobDto.getMaxSalary() );
        job.setAvailable( jobDto.isAvailable() );

        return job;
    }

    protected DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        Integer id = null;
        String departmentName = null;
        LocalDate managerStartDate = null;

        id = department.getId();
        departmentName = department.getDepartmentName();
        if ( department.getManagerStartDate() != null ) {
            managerStartDate = LocalDateTime.ofInstant( department.getManagerStartDate().toInstant(), ZoneOffset.UTC ).toLocalDate();
        }

        DepartmentDto departmentDto = new DepartmentDto( id, departmentName, managerStartDate );

        return departmentDto;
    }

    protected JobDto jobToJobDto(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        jobDto.setId( job.getId() );
        jobDto.setJobTitle( job.getJobTitle() );
        jobDto.setMinSalary( job.getMinSalary() );
        jobDto.setMaxSalary( job.getMaxSalary() );
        jobDto.setAvailable( job.isAvailable() );

        return jobDto;
    }

    protected void departmentDtoToDepartment1(DepartmentDto departmentDto, Department mappingTarget) {
        if ( departmentDto == null ) {
            return;
        }

        if ( departmentDto.getId() != null ) {
            mappingTarget.setId( departmentDto.getId() );
        }
        if ( departmentDto.getDepartmentName() != null ) {
            mappingTarget.setDepartmentName( departmentDto.getDepartmentName() );
        }
        if ( departmentDto.getManagerStartDate() != null ) {
            mappingTarget.setManagerStartDate( Date.from( departmentDto.getManagerStartDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
    }

    protected void jobDtoToJob1(JobDto jobDto, Job mappingTarget) {
        if ( jobDto == null ) {
            return;
        }

        if ( jobDto.getId() != null ) {
            mappingTarget.setId( jobDto.getId() );
        }
        if ( jobDto.getJobTitle() != null ) {
            mappingTarget.setJobTitle( jobDto.getJobTitle() );
        }
        if ( jobDto.getMinSalary() != null ) {
            mappingTarget.setMinSalary( jobDto.getMinSalary() );
        }
        if ( jobDto.getMaxSalary() != null ) {
            mappingTarget.setMaxSalary( jobDto.getMaxSalary() );
        }
        mappingTarget.setAvailable( jobDto.isAvailable() );
    }
}
