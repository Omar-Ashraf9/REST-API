package gov.iti.jets.Soap;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Services.JobService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;

import java.util.List;

@WebService(serviceName = "JobWebService")
@BindingType(jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class JobWebService {

    private JobService jobService = new JobService();

    @WebMethod(operationName = "getAllJobs")
    @WebResult(name = "jobs")
    public List<JobDto> getAllJobs(
            @WebParam(name = "offset") int offset,
            @WebParam(name = "limit") int limit) {
        return jobService.getAllJobs(offset, limit);
    }

    @WebMethod(operationName = "getJobById")
    @WebResult(name = "job")
    public JobDto getJobById(@WebParam(name = "id") Integer id) {
        return jobService.getJobById(id);
    }

    @WebMethod(operationName = "addJob")
    public boolean addJob(@WebParam(name = "job") JobDto job) {
        return jobService.addJob(job);
    }

    @WebMethod(operationName = "deleteJob")
    public void deleteJob(@WebParam(name = "id") Integer id) {
        jobService.deleteJob(id);
    }

    @WebMethod(operationName = "updateJob")
    public boolean updateJob(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "job") JobDto job) {
        job.setId(id);
        return jobService.updateJob(job);
    }

    @WebMethod(operationName = "searchJobs")
    @WebResult(name = "jobs")
    public List<JobDto> searchJobs(@WebParam(name = "title") String title) {
        return jobService.searchJobs(title);
    }
}