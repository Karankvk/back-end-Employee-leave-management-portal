package com.bsolsystems.employeeLeaveManagementPortal.Controller;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.CreateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdatePasswordDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Login;
import com.bsolsystems.employeeLeaveManagementPortal.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:619/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //Create mapping
    @PostMapping("/loginSaveData")
    public boolean saveLogin(@RequestBody Login login) {
        loginService.saveLogin(login);
        return true;
    }

    @PostMapping("/create_login_employee")
    public boolean saveLoginEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        System.out.println("Object from frontEnd => "+createEmployeeDTO);
        loginService.createEmployeeWithLogin(createEmployeeDTO);
        return true;
    }

    @PostMapping("/matchCredential")
    public ResponseEntity<Login> matchCredential(@RequestBody Login login) {
        Login user = loginService.matchCredential(login);

        if(user != null){
            return new ResponseEntity<Login>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<Login>(user, HttpStatus.BAD_REQUEST);
        }
    }

    //Read mapping
    @GetMapping("/loginGetAll")
    public List<Login> getLogin() {
        return loginService.getLogin();
    }

    @GetMapping("/employeeCount")
    public int employeeCount() {
        return loginService.employeeCount();
    }

    @GetMapping("/managerCount")
    public int managerCount() {
        return loginService.managerCount();
    }

    @GetMapping("/employee_details")
    public List<Employee> employeeDetail() {
        return (List<Employee>) loginService.getEmployeeDetail();
    }

    @GetMapping("/employee_specific_leave")
    public List<Leave> employeeSpecificLeave() {
        return (List<Leave>) loginService.getSpecificEmployeeLeave();
    }

    @GetMapping("/employee_role_id")
    public int employeeRoleId() {
        return loginService.employeeRoleId();
    }

    @GetMapping("/employee_percentage")
    public int employeePercentage() {
        return loginService.employeePercentage();
    }

    //Update mapping
    @PutMapping("/loginRoleId")
    public boolean updatePswRoleId(@RequestBody Login login) {
        loginService.updateRoleId(login);
        return true;
    }

    @PutMapping("/loginPassword")
    public boolean updatePasswordWithCheckPassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        loginService.checkPassword(updatePasswordDTO);
        return true;
    }

    @PutMapping("/forgetPassword")
    public boolean updatePassword(@RequestBody Login login) {
        loginService.updateForgetPassword(login);
        return true;
    }

    //Delete mapping
    @DeleteMapping("/loginDeleteData/{id}")
    public boolean deleteDataById(@PathVariable("id") Integer loginID) {
        loginService.deleteLoginById(loginID);
        return true;
    }

}
