package com.bsolsystems.employeeLeaveManagementPortal.Controller;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.Entity.Role;
import com.bsolsystems.employeeLeaveManagementPortal.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:619/")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
