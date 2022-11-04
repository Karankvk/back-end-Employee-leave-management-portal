package com.bsolsystems.employeeLeaveManagementPortal.Service;

import com.bsolsystems.employeeLeaveManagementPortal.Model.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    void inIt();
    void save(MultipartFile file);
    Resource get(String fileName);
    Stream<Path> getAll();
    void softDelete(File fileName);
    void permanentDelete(File fileName);
//    void deleteAll(File fileName);

}
