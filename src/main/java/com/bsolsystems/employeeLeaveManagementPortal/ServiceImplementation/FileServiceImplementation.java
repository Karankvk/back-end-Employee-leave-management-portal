package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Service.FileService;
import com.sun.jna.platform.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileServiceImplementation implements FileService {

    private Path root = Paths.get("D:\\Employee leave management portal\\Review\\FrontEnd\\EmployeeLeaveManagementPortal\\src\\assets");

    @Override
    public void inIt() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    //Post
    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: ");
        }
    }

    //Read
    @Override
    public Resource get(String fileName) {
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file! 😱😨");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    //To download
    @Override
    public Stream<Path> getAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files! 😨😱");
        }
    }

    //Delete
    @Override
    public void softDelete(com.bsolsystems.employeeLeaveManagementPortal.Model.File fileName) {
        File file = new File("D:\\Employee leave management portal\\Review\\FrontEnd\\EmployeeLeaveManagementPortal\\src\\assets\\" + fileName.getFileName());
        FileUtils fileUtils = FileUtils.getInstance();
        if (fileUtils.hasTrash()) {
            try {
                fileUtils.moveToTrash(new File[]{file});
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No Trash!");
        }
    }

    @Override
    public void permanentDelete(com.bsolsystems.employeeLeaveManagementPortal.Model.File fileName) {
        File toDelete = new File("D:\\Employee leave management portal\\Review\\FrontEnd\\EmployeeLeaveManagementPortal\\src\\assets\\" + fileName.getFileName());
        toDelete.delete();
    }

//    @Override
//    public void deleteAll(com.example.demo.Model.File fileName) {
//        Path root = Paths.get("D:\Employee leave management portal\Review\FrontEnd\EmployeeLeaveManagementPortal\src\assets\\"+fileName.getFileName());
//
//        FileSystemUtils.deleteRecursively(root.toFile());
//    }

}
