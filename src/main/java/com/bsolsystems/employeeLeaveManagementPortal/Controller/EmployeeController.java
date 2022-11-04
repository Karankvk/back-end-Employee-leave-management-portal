package com.bsolsystems.employeeLeaveManagementPortal.Controller;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.DataTransferObjects;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:619/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Get
    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeService.getEmployee();
    }

    @GetMapping("/employeeGetManager")
    public List<Employee> getAllManager() {
        return (List<Employee>) employeeService.getManager();
    }

    @GetMapping("/employee/{id}")
    public List<Employee> getEmployeeById(@PathVariable("id") Integer empId){
        return (List<Employee>) employeeService.getEmployeeById(empId);
    }

    @GetMapping("/employee_deleted_employees")
    public List<Employee> deletedEmployees() {
        return (List<Employee>) employeeService.getDeletedEmployee();
    }

    @GetMapping("/employee_login_role")
    public List<DataTransferObjects> employeeLoginRole() {
        return (List<DataTransferObjects>) employeeService.getEmployeeLoginRole();
    }

    //Post
    @PostMapping("/employee")
    public boolean saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return true;
    }

    //Put
    @PutMapping("/employee")
    public boolean updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return true;
    }

    @PutMapping("/update_employee_role")
    public boolean updateEmployeeRole(@RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        employeeService.updateEmployeeWithLogin(updateEmployeeDTO);
        return true;
    }

//    Delete
    @DeleteMapping("/delete_employee/{id}")
    public boolean deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return true;
    }
}
