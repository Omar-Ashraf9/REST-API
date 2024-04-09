package gov.iti.jets.Controllers;

import gov.iti.jets.Models.DTO.DepartmentDto;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentResourceTest {

    @Test
    public void testGetAllDepartments() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/departments");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetDepartmentById() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/departments/{id}");
        WebTarget resolvedTarget = target.resolveTemplate("id", 1); // replace 1 with the actual department ID
        Invocation.Builder request = resolvedTarget.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // If the department ID does not exist, the response status should be NOT_FOUND
        //assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void testAddDepartment() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/departments");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        DepartmentDto department = new DepartmentDto();
        // Set the properties of the department here

        Entity<DepartmentDto> departmentEntity = Entity.entity(department, MediaType.APPLICATION_JSON);

        // Act
        Response response = request.post(departmentEntity);

        // Assert
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeleteDepartment() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/departments/{id}");
        WebTarget resolvedTarget = target.resolveTemplate("id", 4); // replace 1 with the actual department ID
        Invocation.Builder request = resolvedTarget.request();

        // Act
        Response response = request.delete();

        // Assert
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

        // If the department ID does not exist, the response status should be NOT_FOUND
        //assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}