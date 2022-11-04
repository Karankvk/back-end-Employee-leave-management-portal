package com.bsolsystems.employeeLeaveManagementPortal.Controller;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import com.bsolsystems.employeeLeaveManagementPortal.Model.ResponseMessage;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeInformationService;
import com.bsolsystems.employeeLeaveManagementPortal.helper.EmployeeInformationHelper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v6")
@CrossOrigin("http://localhost:619/")
public class EmployeeInformationController {

    @Autowired
    EmployeeInformationService employeeInformationService;

    //    Create
    @PostMapping("/save_excel")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (EmployeeInformationHelper.hasExcelFormat(file)) {
            try {
                employeeInformationService.saveExcelToDB(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @PostMapping("/save_employee")
    public ResponseEntity<ResponseMessage> saveEmployee(@RequestBody EmployeeInformation employeeInformation) {
        String message = "";
        try {
            employeeInformationService.saveEmployee(employeeInformation);
            message = "Employee saved successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee not saved check you details.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

    //    Read
    @GetMapping("/get_employees")
    public ResponseEntity<List<EmployeeInformation>> getAllEmployees() {
        try {
            List<EmployeeInformation> employeeInformations = employeeInformationService.getAllEmployee();
            if (employeeInformations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(employeeInformations, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String fileName = "Employee.xlsx";
        InputStreamResource file = new InputStreamResource(employeeInformationService.getDBToExcel());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
    }

    @GetMapping("/order_by_employee_gender")
    public ResponseEntity<List<EmployeeInformation>> getEmployeeByOrder() {
        try {
            List<EmployeeInformation> employeeInformations = employeeInformationService.getAllEmployeeByOrderGender();
            if (employeeInformations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(employeeInformations, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("order_by_employee_name")
    public ResponseEntity<List<EmployeeInformation>> getEmployeeByOrderName() {
        try {
            List<EmployeeInformation> employeeInformations = employeeInformationService.getAllEmployeeByOrderName();
            if (employeeInformations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(employeeInformations, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Update
    @PutMapping("/update_employee")
    public ResponseEntity<ResponseMessage> updateEmployee(@RequestBody EmployeeInformation employeeInformation) {
        String message = "";
        try {
            employeeInformationService.editEmployee(employeeInformation);
            message = "Employee updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee is not updated. Please check your details";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

    //    Delete
    @PutMapping("/delete_employee")
    public ResponseEntity<ResponseMessage> deleteEmployee(@RequestBody EmployeeInformation employeeInformation) {
        String message = "";
        try {
            employeeInformationService.deleteEmployee(employeeInformation);
            message = "Employee deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Employee is not deleted. Please check your details";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

}
