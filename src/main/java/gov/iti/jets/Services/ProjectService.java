package gov.iti.jets.Services;

import gov.iti.jets.Exceptions.ResourceNotFoundException;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Models.Mappers.ProjectMapper;
import gov.iti.jets.Persistence.DB;
import gov.iti.jets.Persistence.Entities.Department;
import gov.iti.jets.Persistence.Entities.Project;
import gov.iti.jets.Persistence.Repository.ProjectRepo;

import java.util.List;

public class ProjectService {

    public ProjectService() {}

    public List<ProjectDto> getAllProjects(int offset, int limit) {
        return DB.doInTransaction(em -> {
            ProjectRepo projectRepo = new ProjectRepo(em);
            List<Project> projects = projectRepo.findAll(offset, limit).orElse(null);
            return ProjectMapper.INSTANCE.toDtoList(projects);
        });
    }

    public ProjectDto getProjectById(Integer id) {
        return DB.doInTransaction(em -> {
            ProjectRepo projectRepo = new ProjectRepo(em);
            Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No project found with the provided ID"));
            return ProjectMapper.INSTANCE.toDto(project);
        });
    }

    public boolean addProject(ProjectDto projectDto) {
        return DB.doInTransaction(em -> {
            ProjectRepo projectRepo = new ProjectRepo(em);
            Department department = em.find(Department.class, projectDto.getDepartmentId());
            Project project = ProjectMapper.INSTANCE.toEntity(projectDto);
            project.setDepartment(department);
            try {
                projectRepo.create(project);
                return true;
            } catch (Exception e) {
                System.out.println("Error adding project: " + e.getMessage());
                return false;
            }
        });
    }

    public boolean deleteProject(Integer id) {
        return DB.doInTransaction(em -> {
            ProjectRepo projectRepo = new ProjectRepo(em);
            Project project = projectRepo.findById(id).orElse(null);
            if (project != null) {
                project.setAvailable(false);
                projectRepo.update(project);
                return true;
            }
            return false;
        });
    }

}
