package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Persistence.Entities.Project;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T03:54:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setProjectName( projectDto.getProjectName() );
        project.setAvailable( projectDto.isAvailable() );
        project.setDepartmentName( projectDto.getDepartmentName() );
        project.setDepartmentId( projectDto.getDepartmentId() );

        return project;
    }

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setProjectName( project.getProjectName() );
        projectDto.setDepartmentName( project.getDepartmentName() );
        projectDto.setDepartmentId( project.getDepartmentId() );
        projectDto.setAvailable( project.isAvailable() );

        return projectDto;
    }

    @Override
    public List<ProjectDto> toDtoList(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( toDto( project ) );
        }

        return list;
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
        project.setAvailable( projectDto.isAvailable() );
        if ( projectDto.getDepartmentName() != null ) {
            project.setDepartmentName( projectDto.getDepartmentName() );
        }
        if ( projectDto.getDepartmentId() != null ) {
            project.setDepartmentId( projectDto.getDepartmentId() );
        }

        return project;
    }
}
