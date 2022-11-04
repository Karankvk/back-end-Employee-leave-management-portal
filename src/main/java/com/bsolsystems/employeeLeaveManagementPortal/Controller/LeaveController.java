package com.bsolsystems.employeeLeaveManagementPortal.Controller;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.EmployeeLeaveDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
@CrossOrigin(origins = "http://localhost:619/")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    //Get
    @GetMapping("/get_leave")
    public List<Leave> getLeave() {
        return leaveService.getLeave();
    }

    @GetMapping("/managerLeaves")
    public List<EmployeeLeaveDTO> allManagerLeaves() {
        return (List<EmployeeLeaveDTO>) leaveService.getManagerLeave();
    }

    @GetMapping("/employeeLeaves")
    public List<EmployeeLeaveDTO> allEmployeeLeaves() {
        return leaveService.getEmployeeLeave();
    }

    @GetMapping("/countLeaveApproved")
    public int countLeaveApproved() {
        return leaveService.countLeaveApproved();
    }

    @GetMapping("/countLeaveNotApproved")
    public int countLeaveNotApproved() {
        return leaveService.countLeaveNotApproved();
    }

    @GetMapping("/countManagerLeave")
    public int countManagerLeave() {
        return leaveService.countManagerLeave();
    }

    @GetMapping("/countEmployeeLeave")
    public int countEmployeeLeave() {
        return leaveService.countEmployeeLeaves();
    }

    @GetMapping("/array_employee_manager")
    public int[] arrayEmployeeManager() {
        return leaveService.arrayEmployeeManagerCount();
    }

    @GetMapping("/employee_revoked_leave")
    public List<EmployeeLeaveDTO> employeeRevokedLeave() {
        return leaveService.getEmployeeRevokeLeave();
    }

    @GetMapping("/manager_revoked_leave")
    public List<EmployeeLeaveDTO> managerRevokedLeave() {
        return leaveService.getManagerRevokeLeave();
    }

    //Post
    @PostMapping("/addLeave")
    public ResponseEntity<Leave> saveLeave(@RequestBody Leave leave) {
        Leave detail = leaveService.saveLeave(leave);
        if(detail != null) {
            return new ResponseEntity<Leave>(detail, HttpStatus.OK);
        }else{
            return new ResponseEntity<Leave>(detail, HttpStatus.BAD_REQUEST);
        }
    }

    //Put
    @PutMapping("/updateLeave")
    public boolean editLeave(@RequestBody Leave leave) {
        leaveService.updateLeave(leave);
        return true;
    }

    @PutMapping("/updateStatus")
    public boolean updateLeaveStatus(@RequestBody Leave leave) {
        leaveService.updateLeaveStatusApproved(leave);
        return true;
    }

    @PutMapping("/update_status_rejected")
    public boolean updateLeaveStatusRejected(@RequestBody Leave leave) {
        leaveService.updateLeaveStatusRejected(leave);
        return true;
    }

    @PutMapping("/revokeLeave")
    public boolean updateLeaveStatusRevoke(@RequestBody Leave leave) {
        leaveService.revokeLeave(leave);
        return true;
    }

}
