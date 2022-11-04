package com.bsolsystems.employeeLeaveManagementPortal.Entity;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "login_detail")
public class Login {

    @Id
    @GeneratedValue
    @Column(name = "Lid")
    private Integer loginId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    @CreationTimestamp
    private Date loginCreated;

    @Column(name = "updated")
    @UpdateTimestamp
    private Date loginUpdated;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "role_rid")
    private Integer role_rid;

    public Login(String username, String password, Date logincreated, Date loginupdated, Integer rolerid, boolean deleted) {
        this.username = username;
        this.password = password;
        this.loginCreated = logincreated;
        this.loginUpdated = loginupdated;
        this.role_rid = rolerid;
        this.deleted = deleted;
    }

    public Login() {

    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginCreated() {
        return loginCreated;
    }

    public void setLoginCreated(Date loginCreated) {
        this.loginCreated = loginCreated;
    }

    public Date getLoginUpdated() {
        return loginUpdated;
    }

    public void setLoginUpdated(Date loginUpdated) {
        this.loginUpdated = loginUpdated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getRoleRid() {
        return role_rid;
    }

    public void setRoleRid(Integer RoleRid) {
        role_rid = RoleRid;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_rid", nullable = false, insertable = false, updatable = false)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(mappedBy = "login")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loginCreated=" + loginCreated +
                ", loginUpdated=" + loginUpdated +
                ", deleted=" + deleted +
                ", role_rid=" + role_rid +
                ", role=" + role +
                ", employee=" + employee +
                '}';
    }
}
