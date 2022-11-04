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
import java.util.Objects;

@Entity
@Table(name = "leave_detail")
public class Leave {

    @Id
    @GeneratedValue
    @Column(name = "leid")
    private Integer leaveId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status = "Un-Approved";

    @Column(name = "created")
    @CreationTimestamp
    private  Date created;

    @Column(name = "updated")
    @UpdateTimestamp
    private Date updated;

    @Column(name = "revoked")
    private Character revoked  = 'n';
//    'n' => Not revoked, 'd' => Revoked

    @Column(name = "employee_eid")
    private Integer employeeID;

    public Leave() {

    }

    public Leave(Date startDate, Date endDate, String leaveType, String reason, String status, Date created, Date updated, Integer employeeID, Character revoked) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.reason = reason;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.employeeID = employeeID;
        this.revoked = revoked;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Character getRevoked() {
        return revoked;
    }

    public void setRevoked(Character revoked) {
        this.revoked = revoked;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveType='" + leaveType + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", revoked=" + revoked +
                ", employeeID=" + employeeID +
                ", employee=" + employee +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Leave)) return false;
//        Leave leave = (Leave) o;
//        return Objects.equals(getLeaveId(), leave.getLeaveId()) && Objects.equals(getStartDate(), leave.getStartDate()) && Objects.equals(getEndDate(), leave.getEndDate()) && Objects.equals(getLeaveType(), leave.getLeaveType()) && Objects.equals(getReason(), leave.getReason()) && Objects.equals(getStatus(), leave.getStatus()) && Objects.equals(getCreated(), leave.getCreated()) && Objects.equals(getUpdated(), leave.getUpdated()) && Objects.equals(getRevoked(), leave.getRevoked()) && Objects.equals(getEmployeeID(), leave.getEmployeeID()) && Objects.equals(getEmployee(), leave.getEmployee());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getLeaveId(), getStartDate(), getEndDate(), getLeaveType(), getReason(), getStatus(), getCreated(), getUpdated(), getRevoked(), getEmployeeID(), getEmployee());
//    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_eid", updatable = false, insertable = false, nullable = false)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
