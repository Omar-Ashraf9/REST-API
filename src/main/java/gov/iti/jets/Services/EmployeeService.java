package gov.iti.jets.Services;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.Mappers.EmployeeMapper;
import gov.iti.jets.Persistence.DB;
import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Repository.EmployeeRepo;

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
}
