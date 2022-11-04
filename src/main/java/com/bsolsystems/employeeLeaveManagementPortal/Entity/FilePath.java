package com.bsolsystems.employeeLeaveManagementPortal.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "file_path")
public class FilePath {

    @Id
    @GeneratedValue
    @Column(name = "path_id")
    private Integer pathId;

    @Column(name = "path")
    private String path;

//    Default constructor
    public FilePath() {}

//    Self define constructor
    public FilePath(Integer pathId, String path) {
        this.pathId = pathId;
        this.path = path;
    }

//    Getter, Setter
    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    toString, equals, hashCode
    @Override
    public String toString() {
        return "FilePath{" +
                "pathId=" + pathId +
                ", path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilePath)) return false;
        FilePath filePath = (FilePath) o;
        return Objects.equals(getPathId(), filePath.getPathId()) && Objects.equals(getPath(), filePath.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPathId(), getPath());
    }
}
