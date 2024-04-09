package gov.iti.jets.Controllers;

import gov.iti.jets.Controllers.Beans.PaginationBean;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Services.ProjectService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/projects")
public class ProjectResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjects(@BeanParam PaginationBean paginationBean) {
        ProjectService projectService = new ProjectService();
        List<ProjectDto> projects = projectService.getAllProjects(paginationBean.getOffset(), paginationBean.getLimit());
        if (projects == null || projects.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No projects found").build();
        }
        return Response.ok(projects).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectById(@PathParam("id") Integer id) {
        ProjectService projectService = new ProjectService();
        ProjectDto project = projectService.getProjectById(id);
        return Response.ok(project).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProject(ProjectDto project) {
        ProjectService projectService = new ProjectService();
        boolean isAdded = projectService.addProject(project);
        if (isAdded) {
            return Response.status(Response.Status.CREATED).entity(project).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("can't add this project").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProject(@PathParam("id") Integer id) {
        ProjectService projectService = new ProjectService();
        boolean isDeleted = projectService.deleteProject(id);
        if (isDeleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No project found with the provided ID").build();
        }
    }

}
