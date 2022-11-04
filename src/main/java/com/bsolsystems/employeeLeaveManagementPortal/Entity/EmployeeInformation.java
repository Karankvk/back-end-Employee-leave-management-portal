package com.bsolsystems.employeeLeaveManagementPortal.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_information")
public class EmployeeInformation {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    //    Default constructor
    public EmployeeInformation() {
    }

    //    Self define constructor
    public EmployeeInformation(Integer employeeId, String firstName, String lastName, String email, String gender, String ipAddress, String mobile, boolean deleted) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
        this.mobile = mobile;
        this.deleted = deleted;
    }

//    Getter and Setter


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    //    toString, equals, hashCode

    @Override
    public String toString() {
        return "EmployeeInformation{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInformation that = (EmployeeInformation) o;
        return deleted == that.deleted && Objects.equals(employeeId, that.employeeId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(gender, that.gender) && Objects.equals(ipAddress, that.ipAddress) && Objects.equals(mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, gender, ipAddress, mobile, deleted);
    }
}
