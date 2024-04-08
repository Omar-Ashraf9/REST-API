package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Persistence.Entities.Department;
import gov.iti.jets.Persistence.Entities.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T15:43:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    private final DepartmentMapper departmentMapper = DepartmentMapper.INSTANCE;

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setProjectName( projectDto.getProjectName() );
        project.setDepartment( departmentMapper.toEntity( projectDto.getDepartment() ) );

        return project;
    }

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        Integer id = null;
        String projectName = null;
        DepartmentDto department = null;

        id = project.getId();
        projectName = project.getProjectName();
        department = departmentMapper.toDto( project.getDepartment() );

        ProjectDto projectDto = new ProjectDto( id, projectName, department );

        return projectDto;
    }

    @Override
    public Project partialUpdate(ProjectDto projectDto, Project project) {
        if ( projectDto == null ) {
            return project;
        }

        if ( projectDto.getId() != null ) {
            project.setId( projectDto.getId() );
        }
        if ( projectDto.getProjectName() != null ) {
            project.setProjectName( projectDto.getProjectName() );
        }
        if ( projectDto.getDepartment() != null ) {
            if ( project.getDepartment() == null ) {
                project.setDepartment( new Department() );
            }
            departmentMapper.partialUpdate( projectDto.getDepartment(), project.getDepartment() );
        }

        return project;
    }
}
