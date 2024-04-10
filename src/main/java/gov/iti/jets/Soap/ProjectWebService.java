package gov.iti.jets.Soap;

import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Services.ProjectService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;

import java.util.List;

@WebService(serviceName = "ProjectWebService")
@BindingType(jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class ProjectWebService {

    private ProjectService projectService = new ProjectService();

    @WebMethod(operationName = "getAllProjects")
    @WebResult(name = "projects")
    public List<ProjectDto> getAllProjects(
            @WebParam(name = "offset") int offset,
            @WebParam(name = "limit") int limit) {
        return projectService.getAllProjects(offset, limit);
    }

    @WebMethod(operationName = "getProjectById")
    @WebResult(name = "project")
    public ProjectDto getProjectById(@WebParam(name = "id") Integer id) {
        return projectService.getProjectById(id);
    }

    @WebMethod(operationName = "addProject")
    public boolean addProject(@WebParam(name = "project") ProjectDto project) {
        return projectService.addProject(project);
    }

    @WebMethod(operationName = "deleteProject")
    public boolean deleteProject(@WebParam(name = "id") Integer id) {
        return projectService.deleteProject(id);
    }
}
