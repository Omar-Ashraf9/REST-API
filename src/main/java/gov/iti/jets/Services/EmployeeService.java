package gov.iti.jets.Services;

import gov.iti.jets.Exceptions.InsufficientVacationBalanceException;
import gov.iti.jets.Exceptions.ResourceNotFoundException;
import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.DTO.EmployeeProjectAssignmentDto;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Models.Mappers.EmployeeMapper;
import gov.iti.jets.Models.Mappers.ProjectMapper;
import gov.iti.jets.Persistence.DB;
import gov.iti.jets.Persistence.Entities.*;
import gov.iti.jets.Persistence.Repository.DepartmentRepo;
import gov.iti.jets.Persistence.Repository.EmployeeRepo;
import gov.iti.jets.Persistence.Repository.JobRepo;
import gov.iti.jets.Persistence.Repository.ProjectRepo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class EmployeeService {
    public EmployeeService() {}

    public List<EmployeeDto> getAllEmployees(int offset, int limit) {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            List<Employee> employees = employeeRepo.findAll(offset, limit).orElse(null);
            return EmployeeMapper.INSTANCE.toDtoList(employees);
        });
    }

    public List<EmployeeDto> getManagers() {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            List<Employee> managers = employeeRepo.findManagers().orElse(null);
            return EmployeeMapper.INSTANCE.toDtoList(managers);
        });
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            Employee employee = employeeRepo.findById(id).orElse(null);
            return EmployeeMapper.INSTANCE.toDto(employee);
        });
    }

    public boolean addEmployee(EmployeeDto employeeDto) {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            JobRepo jobRepo = new JobRepo(em);

            Employee manager = employeeRepo.findById(employeeDto.getManagerId()).orElse(null);
            Department department = departmentRepo.findById(employeeDto.getDepartmentId()).orElse(null);
            Job job = jobRepo.findById(employeeDto.getJobId()).orElse(null);

            if (manager == null || !employeeRepo.isManager(manager) || department == null || job == null) {
                return false;
            }

            Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDto);
            employee.setVacationBalance(30);
            employee.setManager(manager);
            employee.setDepartment(department);
            employee.setJob(job);

            try {
                employeeRepo.create(employee);
                return true;
            } catch (Exception e) {
                System.out.println("Error adding employee: " + e.getMessage());
                return false;
            }
        });
    }

    public void requestVacation(Integer id, int days) {
        DB.doInTransactionWithoutResult(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No employee found with the provided ID"));
            if(employee != null) {
                if (employee.getVacationBalance() < days) {
                    throw new InsufficientVacationBalanceException("Insufficient vacation balance");
                }
                employee.setVacationBalance(employee.getVacationBalance() - days);
                employeeRepo.update(employee);
            }
        });
    }

    public boolean updateEmployee(EmployeeDto employeeDto) {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            JobRepo jobRepo = new JobRepo(em);

            Employee employee = employeeRepo.findById(employeeDto.getId()).orElseThrow(() -> new ResourceNotFoundException("No employee found with the provided ID"));

            if (employeeDto.getFirstName() != null)
                employee.setFirstName(employeeDto.getFirstName());

            if (employeeDto.getLastName() != null)
                employee.setLastName(employeeDto.getLastName());

            if(employeeDto.getBirthDate() != null)
                employee.setBirthDate(employeeDto.getBirthDate());

            if(employeeDto.getAddress() != null)
                employee.setAddress(employeeDto.getAddress());

            if(employeeDto.getGender() != null)
                employee.setGender(employeeDto.getGender());

            if(employeeDto.getSalary() != null)
                employee.setSalary(employeeDto.getSalary());

            if (employeeDto.getManagerId() != null) {
                Employee manager = employeeRepo.findById(employeeDto.getManagerId()).orElseThrow(() -> new ResourceNotFoundException("No manager found with the provided ID"));
                if (!employeeRepo.isManager(manager))
                    throw new ResourceNotFoundException("This employee is not a manager");

                employee.setManager(manager);
            }

            if (employeeDto.getDepartmentId() != null) {
                Department department = departmentRepo.findById(employeeDto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("No department found with the provided ID"));
                employee.setDepartment(department);
            }

            if (employeeDto.getJobId() != null) {
                Job job = jobRepo.findById(employeeDto.getJobId()).orElseThrow(() -> new ResourceNotFoundException("No job found with the provided ID"));
                employee.setJob(job);
            }

            try {
                employeeRepo.update(employee);
                return true;
            } catch (Exception e) {
                System.out.println("Error updating employee: " + e.getMessage());
                return false;
            }
        });
    }

    public void assignToProject(Integer id, EmployeeProjectAssignmentDto assignmentDto) {
        DB.doInTransactionWithoutResult(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            ProjectRepo projectRepo = new ProjectRepo(em);

            Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No employee found with the provided ID"));
            Project project = projectRepo.findById(assignmentDto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("No project found with the provided ID"));

            WorksOnId worksOnId = new WorksOnId();
            worksOnId.setEmployeeId(employee.getId());
            worksOnId.setProjectId(project.getId());

            WorksOn worksOn = new WorksOn();
            worksOn.setId(worksOnId);
            worksOn.setEmployee(employee);
            worksOn.setProject(project);
            em.persist(worksOn);
        });
    }

    public List<ProjectDto> getEmployeeProjects(Integer id) {
        return DB.doInTransaction(em -> {
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No employee found with the provided ID"));

            List<Project> projects = employeeRepo.getProjects(id).orElse(null);

            return ProjectMapper.INSTANCE.toDtoList(projects);
        });
    }
    public java.util.Date map(LocalDate localDate) {
        return localDate != null ? java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
    }
}
