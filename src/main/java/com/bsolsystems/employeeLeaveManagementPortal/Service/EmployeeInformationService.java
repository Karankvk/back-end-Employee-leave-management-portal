package com.bsolsystems.employeeLeaveManagementPortal.Service;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface EmployeeInformationService {

    //    Create
    void saveExcelToDB(MultipartFile file);

    void saveEmployee(EmployeeInformation employeeInformation);

    //    Read
    List<EmployeeInformation> getAllEmployee();

    ByteArrayInputStream getDBToExcel();

    List<EmployeeInformation> getAllEmployeeByOrderGender();

    List<EmployeeInformation> getAllEmployeeByOrderName();

    //    Update
    void editEmployee(EmployeeInformation employeeInformation);

    //    Delete
    void deleteEmployee(EmployeeInformation employeeInformation);

}
