package com.bsolsystems.employeeLeaveManagementPortal.Repository;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface EmployeeInformationRepository {
    // Create
    void saveExcelToDB(MultipartFile file);

    void saveEmployee(EmployeeInformation employeeInformation);

    // Read

    ByteArrayInputStream getDBToExcel();

    List<EmployeeInformation> getAllEmployee();

    List<EmployeeInformation> getAllEmployeeByOrderGender();

    List<EmployeeInformation> getAllEmployeeByOrderName();

    //    Update
    void editEmployee(EmployeeInformation employeeInformation);

    //    Delete
    void deleteEmployee(EmployeeInformation employeeInformation);
}
