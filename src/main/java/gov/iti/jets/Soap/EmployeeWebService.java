package gov.iti.jets.Soap;

import gov.iti.jets.Models.DTO.EmployeeDto;
import gov.iti.jets.Models.DTO.EmployeeProjectAssignmentDto;
import gov.iti.jets.Models.DTO.EmployeeVacationRequestDto;
import gov.iti.jets.Models.DTO.ProjectDto;
import gov.iti.jets.Services.EmployeeService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;

import java.util.List;

@WebService(serviceName = "EmployeeWebService")
@BindingType(jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class EmployeeWebService {

    private EmployeeService employeeService = new EmployeeService();

    @WebMethod(operationName = "getAllEmployees")
    @WebResult(name = "employees")
    public List<EmployeeDto> getAllEmployees(
            @WebParam(name = "offset") int offset,
            @WebParam(name = "limit") int limit) {
        return employeeService.getAllEmployees(offset, limit);
    }

    @WebMethod(operationName = "getManagers")
    @WebResult(name = "managers")
    public List<EmployeeDto> getManagers() {
        return employeeService.getManagers();
    }

    @WebMethod(operationName = "getEmployeeById")
    @WebResult(name = "employee")
    public EmployeeDto getEmployeeById(@WebParam(name = "id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @WebMethod(operationName = "addEmployee")
    public boolean addEmployee(@WebParam(name = "employee") EmployeeDto employee) {
        return employeeService.addEmployee(employee);
    }

    @WebMethod(operationName = "requestVacation")
    public void requestVacation(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "vacationRequest") EmployeeVacationRequestDto vacationRequest) {
        employeeService.requestVacation(id, vacationRequest.getDays());
    }

    @WebMethod(operationName = "updateEmployee")
    public boolean updateEmployee(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "employee") EmployeeDto employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @WebMethod(operationName = "assignToProject")
    public void assignToProject(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "assignmentDto") EmployeeProjectAssignmentDto assignmentDto) {
        employeeService.assignToProject(id, assignmentDto);
    }

    @WebMethod(operationName = "getEmployeeProjects")
    @WebResult(name = "projects")
    public List<ProjectDto> getEmployeeProjects(@WebParam(name = "id") Integer id) {
        return employeeService.getEmployeeProjects(id);
    }
}
