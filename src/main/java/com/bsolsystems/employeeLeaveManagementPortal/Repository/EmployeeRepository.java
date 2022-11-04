package com.bsolsystems.employeeLeaveManagementPortal.Repository;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.DataTransferObjects;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;


import java.util.List;

public interface EmployeeRepository {

    //Save operation
    void saveEmployee(Employee employee);

    //Read operation
    List<Employee> getEmployee();
    List<Employee> getManager();
    List<Employee> getEmployeeById(Integer EID);
    List<Employee> getDeletedEmployee();
    List<DataTransferObjects> getEmployeeLoginRole();

    //Update operation
    void updateEmployee(Employee employee);
    void updateEmployeeWithLogin(UpdateEmployeeDTO updateEmployeeDTO);

    //Delete operation
    void deleteEmployee(Integer id);
}
