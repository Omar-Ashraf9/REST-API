package gov.iti.jets.Controllers;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Services.JobService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.experimental.Delegate;

import java.util.List;

@Path("/v1/jobs")
public class JobResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs(@QueryParam("offset") @DefaultValue("0") int offset, @QueryParam("limit") @DefaultValue("10") int limit) {
        JobService jobService = new JobService();
        List<JobDto> jobs = jobService.getAllJobs(offset, limit);
        if (jobs == null || jobs.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(jobs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobById(@PathParam("id") Integer id) {
        JobService jobService = new JobService();
        JobDto job = jobService.getJobById(id);
        if (job == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(job).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addJob(JobDto job) {
        JobService jobService = new JobService();
        boolean isAdded = jobService.addJob(job);
        if (isAdded) {
            return Response.status(Response.Status.CREATED).entity(job).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("can't add this job").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteJob(@PathParam("id") Integer id) {
        JobService jobService = new JobService();
        jobService.deleteJob(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}