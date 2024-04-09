package gov.iti.jets.Controllers;

import gov.iti.jets.Controllers.Beans.PaginationBean;
import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Services.JobService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/jobs")
public class JobResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs(@BeanParam PaginationBean paginationBean) {
        JobService jobService = new JobService();
        List<JobDto> jobs = jobService.getAllJobs(paginationBean.getOffset(), paginationBean.getLimit());
        if (jobs == null || jobs.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No jobs found").build();
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
            return Response.status(Response.Status.NOT_FOUND).entity("No job found with the provided ID").build();
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
            return Response.status(Response.Status.BAD_REQUEST).entity("can't add this job").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteJob(@PathParam("id") Integer id) {
        JobService jobService = new JobService();
        jobService.deleteJob(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateJob(@PathParam("id") Integer id, JobDto job) {
        JobService jobService = new JobService();
        job.setId(id);
        boolean isUpdated = jobService.updateJob(job);
        if (isUpdated) {
            return Response.status(Response.Status.OK).entity(job).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("can't update this job").build();
        }
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchJobs(@QueryParam("title") String title) {
        JobService jobService = new JobService();
        List<JobDto> jobs = jobService.searchJobs(title);
        if (jobs == null || jobs.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No jobs found with this title").build();
        }
        return Response.ok(jobs).build();
    }
}