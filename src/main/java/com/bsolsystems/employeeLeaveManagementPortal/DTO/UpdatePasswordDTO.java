package com.bsolsystems.employeeLeaveManagementPortal.DTO;

import java.util.Objects;

public class UpdatePasswordDTO {
    public String currentPassword;
    public String newPassword;
    public Integer loginId;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatePasswordDTO)) return false;
        UpdatePasswordDTO that = (UpdatePasswordDTO) o;
        return Objects.equals(getCurrentPassword(), that.getCurrentPassword()) && Objects.equals(getNewPassword(), that.getNewPassword()) && Objects.equals(getLoginId(), that.getLoginId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentPassword(), getNewPassword(), getLoginId());
    }
}
