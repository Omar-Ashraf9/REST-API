package gov.iti.jets.Controllers;


import gov.iti.jets.Controllers.Beans.PaginationBean;
import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Services.DepartmentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/departments")
public class DepartmentResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDepartments(@BeanParam PaginationBean paginationBean) {
        DepartmentService departmentService = new DepartmentService();
        List<DepartmentDto> departments = departmentService.getAllDepartments(paginationBean.getOffset(), paginationBean.getLimit());
        if (departments == null || departments.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No departments found").build();
        }
        return Response.ok(departments).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentById(@PathParam("id") Integer id) {
        DepartmentService departmentService = new DepartmentService();
        DepartmentDto department = departmentService.getDepartmentById(id);
        if (department == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No department found with the provided ID").build();
        }
        return Response.ok(department).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDepartment(DepartmentDto department) {
        DepartmentService departmentService = new DepartmentService();
        boolean isAdded = departmentService.addDepartment(department);
        if (isAdded) {
            return Response.status(Response.Status.CREATED).entity(department).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("can't add this department").build();
        }
    }

    @PUT
    @Path("/{departmentId}/manager")
    public Response assignManagerToDepartment(@PathParam("departmentId") Integer departmentId, DepartmentDto managerInfo) {
        DepartmentService departmentService = new DepartmentService();
        System.out.println(managerInfo.getManagerStartDate());
        boolean isAssigned = departmentService.assignManagerToDepartment(departmentId, managerInfo);
        if (isAssigned) {
            return Response.status(Response.Status.OK).entity("Manager assigned to the department successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to assign manager to the department").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDepartmentName(@PathParam("id") Integer id, DepartmentDto department) {
        DepartmentService departmentService = new DepartmentService();
        boolean isUpdated = departmentService.updateDepartmentName(id, department);
        if (isUpdated) {
            return Response.status(Response.Status.OK).entity("Department name updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to update department name").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") Integer id) {
        DepartmentService departmentService = new DepartmentService();
        departmentService.deleteDepartment(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
