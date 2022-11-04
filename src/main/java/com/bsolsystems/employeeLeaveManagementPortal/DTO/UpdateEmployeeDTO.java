package com.bsolsystems.employeeLeaveManagementPortal.DTO;

import java.util.Date;
import java.util.Objects;

public class UpdateEmployeeDTO {
    public Integer loginId;
    public Integer roleId;
    public String name;
    public String designation;
    public Date doj;
    public String qualification;
    public Date dob;
    public String contact;
    public String reporting;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateEmployeeDTO)) return false;
        UpdateEmployeeDTO that = (UpdateEmployeeDTO) o;
        return Objects.equals(getLoginId(), that.getLoginId()) && Objects.equals(getRoleId(), that.getRoleId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDesignation(), that.getDesignation()) && Objects.equals(getDoj(), that.getDoj()) && Objects.equals(getQualification(), that.getQualification()) && Objects.equals(getDob(), that.getDob()) && Objects.equals(getContact(), that.getContact()) && Objects.equals(getReporting(), that.getReporting());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoginId(), getRoleId(), getName(), getDesignation(), getDoj(), getQualification(), getDob(), getContact(), getReporting());
    }
}
