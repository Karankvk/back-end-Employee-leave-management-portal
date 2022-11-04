package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.CreateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdatePasswordDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Login;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.LoginRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplementation implements LoginService {

    @Autowired
    LoginRepository loginRepository;


    @Override
    public void saveLogin(Login login) {
        loginRepository.saveLogin(login);
    }

    @Override
    public void createEmployeeWithLogin(CreateEmployeeDTO createEmployeeDTO) {
        loginRepository.createEmployeeWithLogin(createEmployeeDTO);
    }

    @Override
    public List<Login> getLogin() {
        return loginRepository.getLogin();
    }

    @Override
    public Login matchCredential(Login login) {
        return loginRepository.matchCredential(login);
    }

    @Override
    public int employeeCount() {
        return loginRepository.employeeCount();
    }

    @Override
    public int managerCount() {
        return loginRepository.managerCount();
    }

    @Override
    public List<Employee> getEmployeeDetail() {
        return loginRepository.getEmployeeDetail();
    }

    @Override
    public int employeeRoleId() {
        return loginRepository.employeeRoleId();
    }

    @Override
    public List<Leave> getSpecificEmployeeLeave() {
        return loginRepository.getSpecificEmployeeLeave();
    }

    @Override
    public int employeePercentage() {
        return loginRepository.employeePercentage();
    }

    @Override
    public void updateRoleId(Login login) {
        loginRepository.updateRoleId(login);
    }

    @Override
    public void checkPassword(UpdatePasswordDTO updatePasswordDTO) {
        loginRepository.checkPassword(updatePasswordDTO);
    }

    @Override
    public void updatePassword(String newPassword, Integer loginID) {
        loginRepository.updatePassword(newPassword, loginID);
    }

    @Override
    public void updateForgetPassword(Login login) {
        loginRepository.updateForgetPassword(login);
    }

    @Override
    public void deleteLoginById(Integer Lid) {
        loginRepository.deleteLoginById(Lid);
    }
}
