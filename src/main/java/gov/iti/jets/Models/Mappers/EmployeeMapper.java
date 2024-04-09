package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Entities.Job;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDtoList(List<Employee> employees);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee partialUpdate(EmployeeDto employeeDto, @MappingTarget Employee employee);
}