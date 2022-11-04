package com.bsolsystems.employeeLeaveManagementPortal.Service;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.EmployeeLeaveDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import java.util.List;

public interface LeaveService {

    //Create
    Leave saveLeave(Leave leave);

    //Read
    List<Leave> getLeave();
    List<EmployeeLeaveDTO> getManagerLeave();
    List<EmployeeLeaveDTO> getEmployeeLeave();

    int countLeaveApproved();

    int countLeaveNotApproved();

    int countManagerLeave();

    int countEmployeeLeaves();

    int[] arrayEmployeeManagerCount();

    List<EmployeeLeaveDTO> getEmployeeRevokeLeave();

    List<EmployeeLeaveDTO> getManagerRevokeLeave();

    //Update
    void updateLeave(Leave leave);
    void updateLeaveStatusApproved(Leave leave);
    void updateLeaveStatusRejected(Leave leave);

    void revokeLeave(Leave leave);

}
