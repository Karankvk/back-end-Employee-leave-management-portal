package com.bsolsystems.employeeLeaveManagementPortal.Controller;

import com.bsolsystems.employeeLeaveManagementPortal.Model.File;
import com.bsolsystems.employeeLeaveManagementPortal.Model.ResponseMessage;
import com.bsolsystems.employeeLeaveManagementPortal.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v5")
@CrossOrigin("http://localhost:619/")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        java.io.File gotFile = new java.io.File("D:\\Employee leave management portal\\Review\\FrontEnd\\EmployeeLeaveManagementPortal\\src\\assets\\"+ file.getOriginalFilename());
        try{
            if(!gotFile.exists()) {
                fileService.save(file);
                message = "Uploaded the file successfully:" + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }
            else{
                message = "File already exist: "+ file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
            }
        }
        catch (Exception e) {
            message = "Could not upload the file: "+ file.getOriginalFilename()+ "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<File>> getListOfFiles() {
        List<File> file = fileService.getAll().map(path -> {
            String filename = path.getFileName().toString();
//            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
            String url = "D:\\Employee leave management portal\\Review\\FrontEnd\\EmployeeLeaveManagementPortal\\src\\assets\\";
            return new File(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(file);
    }

    @ResponseBody
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = fileService.get(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/soft_delete_file")
    public ResponseEntity<ResponseMessage> softDelete(@RequestBody File fileName) {
        String message = "";
        try {
            fileService.softDelete(fileName);
            message = "File deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch(Exception e) {
            e.printStackTrace();
            message = "Selected file does not exist";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/permanent_delete_file")
    public ResponseEntity<ResponseMessage> permanentDelete(@RequestBody File fileName) {
        String message = "";
        try {
            fileService.permanentDelete(fileName);
            message = "File deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch(Exception e) {
            message = "Selected file does not exist";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

//    @DeleteMapping("/delete_all")
//    public ResponseEntity<ResponseMessage> deleteAll(@RequestBody File fileName) {
//        String message = "";
//        try {
//            fileService.deleteAll(fileName);
//            message = "File deleted successfully";
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//        } catch(Exception e) {
//            message = "Selected file does not exist";
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
//        }
//    }
}
