package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Persistence.Entities.Job;
import gov.iti.jets.Persistence.Entities.Project;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {DepartmentMapper.class})
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    Project toEntity(ProjectDto projectDto);

    ProjectDto toDto(Project project);


    List<ProjectDto> toDtoList(List<Project> projects);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDto projectDto, @MappingTarget Project project);
}