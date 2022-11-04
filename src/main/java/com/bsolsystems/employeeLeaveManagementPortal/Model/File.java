package com.bsolsystems.employeeLeaveManagementPortal.Model;

import java.util.Objects;

public class File {
    private String fileName;
    private String fileUrl;

//    Custom constructor
    public File(String fileName, String fileUrl) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

//    Getter and setter
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

//    toString, equals, hashCode

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return Objects.equals(getFileName(), file.getFileName()) && Objects.equals(getFileUrl(), file.getFileUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileName(), getFileUrl());
    }
}
