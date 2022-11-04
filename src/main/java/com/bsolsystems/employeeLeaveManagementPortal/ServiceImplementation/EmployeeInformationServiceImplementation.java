package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeInformationRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class EmployeeInformationServiceImplementation implements EmployeeInformationService {

    @Autowired
    EmployeeInformationRepository employeeInformationRepository;


    //    Create
    @Override
    public void saveExcelToDB(MultipartFile file) {
        employeeInformationRepository.saveExcelToDB(file);
    }

    @Override
    public void saveEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.saveEmployee(employeeInformation);
    }

    //    Read
    @Override
    public List<EmployeeInformation> getAllEmployee() {
        return employeeInformationRepository.getAllEmployee();
    }

    @Override
    public ByteArrayInputStream getDBToExcel() {
        return employeeInformationRepository.getDBToExcel();
    }

    @Override
    public List<EmployeeInformation> getAllEmployeeByOrderGender() {
        return employeeInformationRepository.getAllEmployeeByOrderGender();
    }

    @Override
    public List<EmployeeInformation> getAllEmployeeByOrderName() {
        return employeeInformationRepository.getAllEmployeeByOrderName();
    }

    //    Update
    @Override
    public void editEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.editEmployee(employeeInformation);
    }

    //    Delete
    @Override

    public void deleteEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.deleteEmployee(employeeInformation);
    }
}
