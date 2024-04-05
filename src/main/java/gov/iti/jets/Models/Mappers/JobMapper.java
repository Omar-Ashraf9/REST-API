package gov.iti.jets.Models.Mappers;

import gov.iti.jets.Models.DTO.JobDto;
import gov.iti.jets.Persistence.Entities.Job;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
    Job toEntity(JobDto jobDto);

    JobDto toDto(Job job);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Job partialUpdate(JobDto jobDto, @MappingTarget Job job);
}