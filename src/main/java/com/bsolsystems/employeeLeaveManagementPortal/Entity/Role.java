package com.bsolsystems.employeeLeaveManagementPortal.Entity;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role_detail")
public class Role {

    @Id
    @Column(name = "rid")
    private Integer rid;

    @Column(name = "roles")
    private String roles;

    public Role() {

    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "role")
    private List<Login> logins = new ArrayList<>();

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }
}
