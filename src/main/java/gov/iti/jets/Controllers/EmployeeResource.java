package gov.iti.jets.Controllers;

import gov.iti.jets.Controllers.Beans.PaginationBean;
import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Services.EmployeeService;
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



}
