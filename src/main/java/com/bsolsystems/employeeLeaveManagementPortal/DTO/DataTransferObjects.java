package com.bsolsystems.employeeLeaveManagementPortal.DTO;

import java.util.Date;
import java.util.Objects;

public class DataTransferObjects {
    public Integer loginId;
    public Integer roleId;
    public String name;
    public String designation;
    public Date doj;
    public String qualification;
    public Date dob;
    public String contact;
    public String reporting;
    public String username;
    public String role;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getReporting() {
        return reporting;
    }

    public void setReporting(String reporting) {
        this.reporting = reporting;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTransferObjects that = (DataTransferObjects) o;
        return loginId.equals(that.loginId) && roleId.equals(that.roleId) && name.equals(that.name) && designation.equals(that.designation) && doj.equals(that.doj) && qualification.equals(that.qualification) && dob.equals(that.dob) && contact.equals(that.contact) && reporting.equals(that.reporting) && username.equals(that.username) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, roleId, name, designation, doj, qualification, dob, contact, reporting, username, role);
    }
}
