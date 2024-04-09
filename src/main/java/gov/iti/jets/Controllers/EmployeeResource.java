package gov.iti.jets.Controllers;

import gov.iti.jets.Controllers.Beans.PaginationBean;
import gov.iti.jets.Models.DTO.EmployeeDto;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}
