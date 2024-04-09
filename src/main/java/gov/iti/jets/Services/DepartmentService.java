package gov.iti.jets.Services;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Models.Mappers.DepartmentMapper;
import gov.iti.jets.Persistence.DB;
import gov.iti.jets.Persistence.Entities.Department;
import gov.iti.jets.Persistence.Entities.Employee;
import gov.iti.jets.Persistence.Repository.DepartmentRepo;
import gov.iti.jets.Persistence.Repository.EmployeeRepo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class DepartmentService {

    public DepartmentService() {}

    public List<DepartmentDto> getAllDepartments(int offset, int limit) {
        return DB.doInTransaction(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            List<Department> departments = departmentRepo.findAll(offset, limit).orElse(null);
            return DepartmentMapper.INSTANCE.toDtoList(departments);
        });
    }

    public DepartmentDto getDepartmentById(Integer id) {
        return DB.doInTransaction(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            Department department = departmentRepo.findById(id).orElse(null);
            return DepartmentMapper.INSTANCE.toDto(department);
        });
    }

    public boolean addDepartment(DepartmentDto departmentDto) {
        return DB.doInTransaction(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            Department department = DepartmentMapper.INSTANCE.toEntity(departmentDto);
            try {
                departmentRepo.create(department);
                return true;
            } catch (Exception e) {
                System.out.println("Error adding department: " + e.getMessage());
                return false;
            }
        });
    }

    public boolean assignManagerToDepartment(Integer departmentId, DepartmentDto managerInfo) {
        return DB.doInTransaction(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            EmployeeRepo employeeRepo = new EmployeeRepo(em);
            Department department = departmentRepo.findById(departmentId).orElse(null);
            Employee manager = employeeRepo.findById(managerInfo.getManagerId()).orElse(null);
            if (department != null && manager != null) {
                department.setManager(manager);
                department.setManagerStartDate(map(managerInfo.getManagerStartDate()));
                departmentRepo.update(department);
                return true;
            } else {
                return false;
            }
        });
    }

    public void deleteDepartment(Integer id) {
        DB.doInTransactionWithoutResult(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            Department department = departmentRepo.findById(id).orElse(null);
            if (department != null) {
                department.setAvailable(false);
                departmentRepo.update(department);
            }
        });
    }


    public boolean updateDepartmentName(Integer id, DepartmentDto departmentDto) {
        return DB.doInTransaction(em -> {
            DepartmentRepo departmentRepo = new DepartmentRepo(em);
            Department department = departmentRepo.findById(id).orElse(null);
            if (department != null) {
                department.setDepartmentName(departmentDto.getDepartmentName());
                departmentRepo.update(department);
                return true;
            } else {
                return false;
            }
        });
    }
    public java.util.Date map(LocalDate localDate) {
        return localDate != null ? java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
    }

}
