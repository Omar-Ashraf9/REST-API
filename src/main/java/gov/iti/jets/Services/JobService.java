package gov.iti.jets.Services;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Models.Mappers.JobMapper;
import gov.iti.jets.Persistence.DB;
import gov.iti.jets.Persistence.Entities.Job;
import gov.iti.jets.Persistence.Repository.JobRepo;

import java.util.List;

public class JobService {

    public JobService() {}

    public List<JobDto> getAllJobs(int offset, int limit) {
        return DB.doInTransaction(em -> {
            JobRepo jobRepo = new JobRepo(em);
            List<Job> jobs = jobRepo.findAll(offset, limit).orElse(null);
            return JobMapper.INSTANCE.toDtoList(jobs);
        });
    }

    public JobDto getJobById(Integer id) {
        return DB.doInTransaction(em -> {
            JobRepo jobRepo = new JobRepo(em);
            Job job = jobRepo.findById(id).orElse(null);
            return JobMapper.INSTANCE.toDto(job);
        });
    }

    public boolean addJob(JobDto jobDto) {
        return DB.doInTransaction(em -> {
            JobRepo jobRepo = new JobRepo(em);
            Job job = JobMapper.INSTANCE.toEntity(jobDto);
            try {
                jobRepo.create(job);
                return true;
            } catch (Exception e) {
                System.out.println("Error adding job: " + e.getMessage());
                return false;
            }
        });
    }

    public void deleteJob(Integer id) {
        DB.doInTransactionWithoutResult(em -> {
            JobRepo jobRepo = new JobRepo(em);
            Job job = jobRepo.findById(id).orElse(null);
            if (job != null) {
                job.setAvailable(false);
                jobRepo.update(job);
            }
        });
    }
}
