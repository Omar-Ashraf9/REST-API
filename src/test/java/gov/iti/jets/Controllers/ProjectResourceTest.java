package gov.iti.jets.Controllers;

import gov.iti.jets.Models.DTO.ProjectDto;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectResourceTest {

    @Test
    public void testGetAllProjects() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/projects");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetProjectById() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/projects/{id}");
        WebTarget resolvedTarget = target.resolveTemplate("id", 1); // replace 1 with the actual project ID
        Invocation.Builder request = resolvedTarget.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // If the project ID does not exist, the response status should be NOT_FOUND
        //assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void testAddProject() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/projects");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        ProjectDto project = new ProjectDto();
        // Set the properties of the project here

        Entity<ProjectDto> projectEntity = Entity.entity(project, MediaType.APPLICATION_JSON);

        // Act
        Response response = request.post(projectEntity);

        // Assert
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeleteProject() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/projects/{id}");
        WebTarget resolvedTarget = target.resolveTemplate("id", 1); // replace 1 with the actual project ID
        Invocation.Builder request = resolvedTarget.request();

        // Act
        Response response = request.delete();

        // Assert
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

        // If the project ID does not exist, the response status should be NOT_FOUND
        //assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}