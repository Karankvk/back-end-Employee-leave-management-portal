package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */


import com.bsolsystems.employeeLeaveManagementPortal.DTO.EmployeeLeaveDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.LeaveRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImplementation implements LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    @Override
    public Leave saveLeave(Leave leave) {

        return leaveRepository.saveLeave(leave);
    }

    @Override
    public List<Leave> getLeave() {
       return leaveRepository.getLeave();
    }

    @Override
    public List<EmployeeLeaveDTO> getManagerLeave() {
        return leaveRepository.getManagerLeave();
    }

    @Override
    public List<EmployeeLeaveDTO> getEmployeeLeave() {
        return leaveRepository.getEmployeeLeave();
    }

    @Override
    public int countLeaveApproved() {
        return leaveRepository.countLeaveApproved();
    }

    @Override
    public int countLeaveNotApproved() {
        return leaveRepository.countLeaveNotApproved();
    }

    @Override
    public int countManagerLeave() {
        return leaveRepository.countManagerLeave();
    }

    @Override
    public int countEmployeeLeaves() {
        return leaveRepository.countEmployeeLeaves();
    }

    @Override
    public int[] arrayEmployeeManagerCount() {
        return leaveRepository.arrayEmployeeManagerCount();
    }

    @Override
    public List<EmployeeLeaveDTO> getEmployeeRevokeLeave() {
        return leaveRepository.getEmployeeRevokeLeave();
    }

    @Override
    public List<EmployeeLeaveDTO> getManagerRevokeLeave() {
        return leaveRepository.getManagerRevokeLeave();
    }

    @Override
    public void updateLeave(Leave leave) {
        leaveRepository.updateLeave(leave);
    }

    @Override
    public void updateLeaveStatusApproved(Leave leave) {
        leaveRepository.updateLeaveStatusApproved(leave);
    }

    @Override
    public void updateLeaveStatusRejected(Leave leave) {
        leaveRepository.updateLeaveStatusRejected(leave);
    }

    @Override
    public void revokeLeave(Leave leave) {
        leaveRepository.revokeLeave(leave);
    }
}
