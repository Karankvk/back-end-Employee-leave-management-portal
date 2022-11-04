package com.bsolsystems.employeeLeaveManagementPortal.Repository;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.CreateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdatePasswordDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Login;

import java.util.List;

public interface LoginRepository {

    //Save operation
    void saveLogin(Login login);
    void createEmployeeWithLogin(CreateEmployeeDTO createEmployeeDTO);
//    List<Login> loginUser();

    //Read operation
    List<Login> getLogin();
    Login matchCredential(Login login);
    int employeeCount();
    int managerCount();
    List<Employee> getEmployeeDetail();
    int employeeRoleId();

    List<Leave> getSpecificEmployeeLeave();

    int employeePercentage();

    //Update operation
    void updateRoleId(Login login);
    void checkPassword(UpdatePasswordDTO updatePasswordDTO);
    void updatePassword(String newPassword, Integer loginID);
    void updateForgetPassword(Login login);

    //Delete operation
    void deleteLoginById(Integer Lid);

}
