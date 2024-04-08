package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Persistence.Entities.Department;
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
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toEntity(DepartmentDto departmentDto) {
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

    @Override
    public DepartmentDto toDto(Department department) {
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

    @Override
    public Department partialUpdate(DepartmentDto departmentDto, Department department) {
        if ( departmentDto == null ) {
            return department;
        }

        if ( departmentDto.getId() != null ) {
            department.setId( departmentDto.getId() );
        }
        if ( departmentDto.getDepartmentName() != null ) {
            department.setDepartmentName( departmentDto.getDepartmentName() );
        }
        if ( departmentDto.getManagerStartDate() != null ) {
            department.setManagerStartDate( Date.from( departmentDto.getManagerStartDate().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }

        return department;
    }
}
