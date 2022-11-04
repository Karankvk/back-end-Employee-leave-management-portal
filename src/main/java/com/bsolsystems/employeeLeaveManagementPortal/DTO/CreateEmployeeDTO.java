package com.bsolsystems.employeeLeaveManagementPortal.DTO;

import java.util.Date;
import java.util.Objects;

public class CreateEmployeeDTO {
    public String userName;
    public String password;
    public Integer roleId;
    public String employeeName;
    public String designation;
    public Date dateOfJoining;
    public String qualification;
    public Date dateOfBirth;
    public String contact;
    public String reporting;
    public Integer loginId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "CreateEmployeeDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", qualification='" + qualification + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", contact='" + contact + '\'' +
                ", reporting='" + reporting + '\'' +
                ", loginId=" + loginId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateEmployeeDTO)) return false;
        CreateEmployeeDTO that = (CreateEmployeeDTO) o;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getRoleId(), that.getRoleId()) && Objects.equals(getEmployeeName(), that.getEmployeeName()) && Objects.equals(getDesignation(), that.getDesignation()) && Objects.equals(getDateOfJoining(), that.getDateOfJoining()) && Objects.equals(getQualification(), that.getQualification()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getContact(), that.getContact()) && Objects.equals(getReporting(), that.getReporting()) && Objects.equals(getLoginId(), that.getLoginId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), getRoleId(), getEmployeeName(), getDesignation(), getDateOfJoining(), getQualification(), getDateOfBirth(), getContact(), getReporting(), getLoginId());
    }
}
