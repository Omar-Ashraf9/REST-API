package gov.iti.jets.Soap;

import gov.iti.jets.Models.DTO.DepartmentDto;
import gov.iti.jets.Services.DepartmentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;

import java.util.List;

@WebService(serviceName = "DepartmentWebService")
@BindingType(jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class DepartmentWebService {

    private DepartmentService departmentService = new DepartmentService();

    @WebMethod(operationName = "getAllDepartments")
    @WebResult(name = "departments")
    public List<DepartmentDto> getAllDepartments(
            @WebParam(name = "offset") int offset,
            @WebParam(name = "limit") int limit) {
        return departmentService.getAllDepartments(offset, limit);
    }

    @WebMethod(operationName = "getDepartmentById")
    @WebResult(name = "department")
    public DepartmentDto getDepartmentById(@WebParam(name = "id") Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @WebMethod(operationName = "addDepartment")
    public boolean addDepartment(@WebParam(name = "department") DepartmentDto department) {
        return departmentService.addDepartment(department);
    }

    @WebMethod(operationName = "assignManagerToDepartment")
    public boolean assignManagerToDepartment(
            @WebParam(name = "departmentId") Integer departmentId,
            @WebParam(name = "managerInfo") DepartmentDto managerInfo) {
        return departmentService.assignManagerToDepartment(departmentId, managerInfo);
    }

    @WebMethod(operationName = "updateDepartmentName")
    public boolean updateDepartmentName(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "department") DepartmentDto department) {
        return departmentService.updateDepartmentName(id, department);
    }

    @WebMethod(operationName = "deleteDepartment")
    public void deleteDepartment(@WebParam(name = "id") Integer id) {
        departmentService.deleteDepartment(id);
    }
}
