package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.DataTransferObjects;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.getEmployee();
    }

    @Override
    public List<Employee> getManager() {
        return employeeRepository.getManager();
    }

    @Override
    public List<Employee> getEmployeeById(Integer EID) {
        return employeeRepository.getEmployeeById(EID);
    }

    @Override
    public List<Employee> getDeletedEmployee() {
        return employeeRepository.getDeletedEmployee();
    }

    @Override
    public List<DataTransferObjects> getEmployeeLoginRole() {
        return employeeRepository.getEmployeeLoginRole();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void updateEmployeeWithLogin(UpdateEmployeeDTO updateEmployeeDTO) {
        employeeRepository.updateEmployeeWithLogin(updateEmployeeDTO);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteEmployee(id);
    }
}
