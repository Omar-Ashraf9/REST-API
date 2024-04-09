package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Persistence.Entities.Job;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T21:16:10+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class JobMapperImpl implements JobMapper {

    @Override
    public Job toEntity(JobDto jobDto) {
        if ( jobDto == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( jobDto.getId() );
        job.setJobTitle( jobDto.getJobTitle() );
        job.setMinSalary( jobDto.getMinSalary() );
        job.setMaxSalary( jobDto.getMaxSalary() );
        job.setAvailable( jobDto.isAvailable() );

        return job;
    }

    @Override
    public JobDto toDto(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        jobDto.setId( job.getId() );
        jobDto.setJobTitle( job.getJobTitle() );
        jobDto.setMinSalary( job.getMinSalary() );
        jobDto.setMaxSalary( job.getMaxSalary() );
        jobDto.setAvailable( job.isAvailable() );

        return jobDto;
    }

    @Override
    public List<JobDto> toDtoList(List<Job> jobs) {
        if ( jobs == null ) {
            return null;
        }

        List<JobDto> list = new ArrayList<JobDto>( jobs.size() );
        for ( Job job : jobs ) {
            list.add( toDto( job ) );
        }

        return list;
    }

    @Override
    public Job partialUpdate(JobDto jobDto, Job job) {
        if ( jobDto == null ) {
            return job;
        }

        if ( jobDto.getId() != null ) {
            job.setId( jobDto.getId() );
        }
        if ( jobDto.getJobTitle() != null ) {
            job.setJobTitle( jobDto.getJobTitle() );
        }
        if ( jobDto.getMinSalary() != null ) {
            job.setMinSalary( jobDto.getMinSalary() );
        }
        if ( jobDto.getMaxSalary() != null ) {
            job.setMaxSalary( jobDto.getMaxSalary() );
        }
        job.setAvailable( jobDto.isAvailable() );

        return job;
    }
}
