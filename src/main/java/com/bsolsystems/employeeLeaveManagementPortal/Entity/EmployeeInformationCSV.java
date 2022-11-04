package com.bsolsystems.employeeLeaveManagementPortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "employee_information_csv")
public class EmployeeInformationCSV {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

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

    public EmployeeInformationCSV() {

    }

    public EmployeeInformationCSV(String first_name, String last_name, String email, String gender, String ipAddress, String mobile) {
//        this.employeeId = employeeId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
        this.mobile = mobile;
//        this.deleted = deleted;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
        return "EmployeeInformationCSV{" +
                "employeeId=" + employeeId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
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
        EmployeeInformationCSV that = (EmployeeInformationCSV) o;
        return deleted == that.deleted && Objects.equals(employeeId, that.employeeId) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(email, that.email) && Objects.equals(gender, that.gender) && Objects.equals(ipAddress, that.ipAddress) && Objects.equals(mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, first_name, last_name, email, gender, ipAddress, mobile, deleted);
    }
}
