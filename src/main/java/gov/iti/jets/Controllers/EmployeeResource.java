package gov.iti.jets.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import gov.iti.jets.Controllers.Beans.PaginationBean;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.DTO.EmployeeProjectAssignmentDto;
import gov.iti.jets.Models.DTO.EmployeeVacationRequestDto;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Services.EmployeeService;
import gov.iti.jets.Views.View;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/employees")
public class EmployeeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees(@BeanParam PaginationBean paginationBean) {
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDto> employees = employeeService.getAllEmployees(paginationBean.getOffset(), paginationBean.getLimit());
        if (employees == null || employees.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No employees found").build();
        }
        return Response.ok(employees).build();
    }

    @GET
    @Path("/managers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagers() {
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDto> managers = employeeService.getManagers();
        if (managers == null || managers.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No managers found").build();
        }
        return Response.ok(managers).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") Integer id) {
        EmployeeService employeeService = new EmployeeService();
        EmployeeDto employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No employee found with the provided ID").build();
        }
        return Response.ok(employee).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(EmployeeDto employee) {
        EmployeeService employeeService = new EmployeeService();
        boolean isAdded = employeeService.addEmployee(employee);
        if (isAdded) {
            return Response.status(Response.Status.CREATED).entity(employee).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("can't add this employee, you might've provided invalid id").build();
        }
    }

    @POST
    @Path("/{id}/vacation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response requestVacation(@PathParam("id") Integer id, EmployeeVacationRequestDto vacationRequest) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.requestVacation(id, vacationRequest.getDays());
        return Response.status(Response.Status.OK).entity("Vacation request processed successfully").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") Integer id, EmployeeDto employee) {
        EmployeeService employeeService = new EmployeeService();
        employee.setId(id);
        boolean isUpdated = employeeService.updateEmployee(employee);
        if (isUpdated) {
            return Response.status(Response.Status.OK).entity(employee).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("can't update this employee").build();
        }
    }

    @POST
    @Path("/{id}/projects")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignToProject(@PathParam("id") Integer id, EmployeeProjectAssignmentDto assignmentDto) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.assignToProject(id, assignmentDto);
        return Response.status(Response.Status.OK).entity("Employee assigned to project successfully").build();
    }

    @GET
    @Path("/{id}/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeProjects(@PathParam("id") Integer id) {
        EmployeeService employeeService = new EmployeeService();
        List<ProjectDto> projects = employeeService.getEmployeeProjects(id);
        if (projects == null || projects.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("This employee is not working on any project currently").build();
        }
        return Response.status(Response.Status.OK).entity(projects).build();
    }

}
