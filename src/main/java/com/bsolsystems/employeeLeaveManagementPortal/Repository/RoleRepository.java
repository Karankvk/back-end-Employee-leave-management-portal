package com.bsolsystems.employeeLeaveManagementPortal.Repository;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.Entity.Role;

import java.util.List;

public interface RoleRepository {

    //Read operation
    List<Role> getRoles();
}
