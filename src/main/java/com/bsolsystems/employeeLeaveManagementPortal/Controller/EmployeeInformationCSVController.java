package com.bsolsystems.employeeLeaveManagementPortal.Controller;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformationCSV;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeInformationCSVService;
import com.bsolsystems.employeeLeaveManagementPortal.helper.EmployeeInformationCSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bsolsystems.employeeLeaveManagementPortal.Model.ResponseMessage;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v7")
@CrossOrigin("http://localhost:619/")
public class EmployeeInformationCSVController {

    @Autowired
    EmployeeInformationCSVService employeeInformationCSVService;

    //    Create
    @PostMapping("/upload_csv_to_db")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (EmployeeInformationCSVHelper.hasCSVFormat(file)) {
            try {
                employeeInformationCSVService.saveCsvToDb(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a CSV file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


    @PostMapping("/save_employee")
    public ResponseEntity<ResponseMessage> saveEmployee(@RequestBody EmployeeInformationCSV employeeInformationCSV) {
        String message = "";
        try {
            employeeInformationCSVService.saveEmployee(employeeInformationCSV);
            message = "Employee saved successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee not saved check you details.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }


//    Read

    @GetMapping("/get_db_data")
    public ResponseEntity<List<EmployeeInformationCSV>> getAllDbData() {
        try {
            List<EmployeeInformationCSV> employeeInformationCSVS = employeeInformationCSVService.getAllData();
            if (employeeInformationCSVS.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeInformationCSVS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/order_by_employee_gender")
    public ResponseEntity<List<EmployeeInformationCSV>> getEmployeeByOrder() {
        try {
            List<EmployeeInformationCSV> employeeInformationCSVs = employeeInformationCSVService.getAllEmployeeByOrderGender();
            if (employeeInformationCSVs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(employeeInformationCSVs, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("order_by_employee_name")
    public ResponseEntity<List<EmployeeInformationCSV>> getEmployeeByOrderName() {
        try {
            List<EmployeeInformationCSV> employeeInformationCSVs = employeeInformationCSVService.getAllEmployeeByOrderName();
            if (employeeInformationCSVs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(employeeInformationCSVs, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Download_CSV")
    public ResponseEntity<Resource> getFileInCSV() {
        String fileName = "Employee Information.csv";
        InputStreamResource inputStreamResource = new InputStreamResource(employeeInformationCSVService.downloadDbToCSV());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/csv")).body(inputStreamResource);
    }

//Update

    @PutMapping("/update_employee")
    public ResponseEntity<ResponseMessage> updateEmployee(@RequestBody EmployeeInformationCSV employeeInformationCSV) {
        String message = "";
        try {
            employeeInformationCSVService.editEmployee(employeeInformationCSV);
            message = "Employee updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee is not updated. Please check your details";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

    //    Delete
    @PutMapping("/delete_employee")
    public ResponseEntity<ResponseMessage> deleteEmployee(@RequestBody EmployeeInformationCSV employeeInformationCSV) {
        String message = "";
        try {
            employeeInformationCSVService.deleteEmployee(employeeInformationCSV);
            message = "Employee deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee is not deleted. Please check your details";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }


}
