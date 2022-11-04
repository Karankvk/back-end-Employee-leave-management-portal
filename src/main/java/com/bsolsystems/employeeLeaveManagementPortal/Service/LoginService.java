package com.bsolsystems.employeeLeaveManagementPortal.Service;
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

public interface LoginService {

    //Save operation
    void saveLogin(Login login);
//    List<Login> loginUser();
    void createEmployeeWithLogin(CreateEmployeeDTO createEmployeeDTO);

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
