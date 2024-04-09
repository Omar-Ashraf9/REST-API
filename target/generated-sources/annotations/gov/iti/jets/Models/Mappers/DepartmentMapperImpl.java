package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Persistence.Entities.Department;
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
        department.setAvailable( departmentDto.isAvailable() );
        department.setManagerName( departmentDto.getManagerName() );
        department.setManagerId( departmentDto.getManagerId() );

        return department;
    }

    @Override
    public DepartmentDto toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setDepartmentName( department.getDepartmentName() );
        if ( department.getManagerStartDate() != null ) {
            departmentDto.setManagerStartDate( LocalDateTime.ofInstant( department.getManagerStartDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        departmentDto.setManagerName( department.getManagerName() );
        departmentDto.setManagerId( department.getManagerId() );
        departmentDto.setAvailable( department.isAvailable() );

        return departmentDto;
    }

    @Override
    public List<DepartmentDto> toDtoList(List<Department> departments) {
        if ( departments == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departments.size() );
        for ( Department department : departments ) {
            list.add( toDto( department ) );
        }

        return list;
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
        department.setAvailable( departmentDto.isAvailable() );
        if ( departmentDto.getManagerName() != null ) {
            department.setManagerName( departmentDto.getManagerName() );
        }
        if ( departmentDto.getManagerId() != null ) {
            department.setManagerId( departmentDto.getManagerId() );
        }

        return department;
    }
}
