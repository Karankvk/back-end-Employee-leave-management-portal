package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.Role;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.RoleRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public List<Role> getRoles() {
        return roleRepository.getRoles();
    }
}
