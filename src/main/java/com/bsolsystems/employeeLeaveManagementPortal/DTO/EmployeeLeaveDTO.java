package com.bsolsystems.employeeLeaveManagementPortal.DTO;

import java.util.Date;
import java.util.Objects;

public class EmployeeLeaveDTO {
    public Integer leaveId;
    public String employeeName;
    public Date startDate;
    public Date endDate;
    public String leaveType;
    public String reason;
    public String status;

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeLeaveDTO)) return false;
        EmployeeLeaveDTO that = (EmployeeLeaveDTO) o;
        return Objects.equals(getLeaveId(), that.getLeaveId()) && Objects.equals(getEmployeeName(), that.getEmployeeName()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getLeaveType(), that.getLeaveType()) && Objects.equals(getReason(), that.getReason()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeaveId(), getEmployeeName(), getStartDate(), getEndDate(), getLeaveType(), getReason(), getStatus());
    }
}
