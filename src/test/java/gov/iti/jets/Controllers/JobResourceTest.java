package gov.iti.jets.Controllers;

import gov.iti.jets.Models.DTO.JobDto;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobResourceTest {

    @Test
    public void testGetAllJobs() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/jobs");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetJobById() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/jobs/{id}");
        WebTarget resolvedTarget = target.resolveTemplate("id", 1); // replace 1 with the actual job ID
        Invocation.Builder request = resolvedTarget.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // If the job ID does not exist, the response status should be NOT_FOUND eg: 15
        //assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void testAddJob() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/jobs");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        JobDto job = new JobDto();
        job.setJobTitle("Tester");
        job.setMinSalary(BigDecimal.valueOf(1000.00));
        job.setMaxSalary(BigDecimal.valueOf(2000.00));

        Entity<JobDto> jobEntity = Entity.entity(job, MediaType.APPLICATION_JSON);

        // Act
        Response response = request.post(jobEntity);

        // Assert
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testSearchJobs() {
        // Arrange
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9090/HRREST/webapi/v1/jobs/search?title=System");
        Invocation.Builder request = target.request(MediaType.APPLICATION_JSON);

        // Act
        Response response = request.get();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        // You can also assert the response body if needed
    }
}