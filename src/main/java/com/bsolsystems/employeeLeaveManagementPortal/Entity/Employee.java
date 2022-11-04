package com.bsolsystems.employeeLeaveManagementPortal.Entity;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "eid")
    private Integer employeeId;

    @Column(name = "name")
    private String eName;

    @Column(name = "designation")
    private String eDesignation;

    @Column(name = "date_of_joining")
    private Date doj;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "contact")
    private String contact;

    @Column(name = "reporting")
    private String reporting;

    @Column(name = "created")
    @CreationTimestamp
    private Date employeeCreated;

    @Column(name = "updated")
    @UpdateTimestamp
    private Date employeeUpdated;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "leave_count")
    private Integer leaveCount = 0;

    @Column(name = "resignation_date")
    private Date resignationDate;

    @Column(name = "login_Id")
    private Integer loginId;

    public Employee() {

    }

    public Employee(String eName, String eDesignation, Date doj, String qualification, Date dob, String contact, String reporting, Date employeeCreated, Date employeeUpdated, Integer loginId, boolean deleted, Integer leaveCount, Date resignationDate) {
        this.eName = eName;
        this.eDesignation = eDesignation;
        this.doj = doj;
        this.qualification = qualification;
        this.dob = dob;
        this.contact = contact;
        this.reporting = reporting;
        this.employeeCreated = employeeCreated;
        this.employeeUpdated = employeeUpdated;
        this.loginId = loginId;
        this.deleted = deleted;
        this.leaveCount = leaveCount;
        this.resignationDate = resignationDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteDesignation() {
        return eDesignation;
    }

    public void seteDesignation(String eDesignation) {
        this.eDesignation = eDesignation;
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

    public Date getEmployeeCreated() {
        return employeeCreated;
    }

    public void setEmployeeCreated(Date employeeCreated) {
        this.employeeCreated = employeeCreated;
    }

    public Date getEmployeeUpdated() {
        return employeeUpdated;
    }

    public void setEmployeeUpdated(Date employeeUpdated) {
        this.employeeUpdated = employeeUpdated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Integer leaveCount) {
        this.leaveCount = leaveCount;
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    @OneToMany(mappedBy = "employee")
    private List<Leave> leave;

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "login_id", insertable = false, updatable = false)
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
