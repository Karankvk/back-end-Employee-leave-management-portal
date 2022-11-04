package com.bsolsystems.employeeLeaveManagementPortal.Repository;


import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformationCSV;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface EmployeeInformationCSVRepository {

    //    Create
    void saveCsvToDb(MultipartFile file);

    void saveEmployee(EmployeeInformationCSV employeeInformationCSV);

    //    Read
    List<EmployeeInformationCSV> getAllData();

    List<EmployeeInformationCSV> getAllEmployeeByOrderGender();

    List<EmployeeInformationCSV> getAllEmployeeByOrderName();

    ByteArrayInputStream downloadDbToCSV();

    //    Update
    void editEmployee(EmployeeInformationCSV employeeInformationCSV);

    //    Delete
    void deleteEmployee(EmployeeInformationCSV employeeInformationCSV);
}
