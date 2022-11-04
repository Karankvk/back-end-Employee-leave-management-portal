package com.bsolsystems.employeeLeaveManagementPortal.ServiceImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformationCSV;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeInformationCSVRepository;
import com.bsolsystems.employeeLeaveManagementPortal.Service.EmployeeInformationCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class EmployeeInformationCSVServiceImplementation implements EmployeeInformationCSVService {

    @Autowired
    EmployeeInformationCSVRepository employeeInformationCSVRepository;

//    Create
    @Override
    public void saveCsvToDb(MultipartFile file) {
        employeeInformationCSVRepository.saveCsvToDb(file);
    }

    @Override
    public void saveEmployee(EmployeeInformationCSV employeeInformationCSV) {
        employeeInformationCSVRepository.saveEmployee(employeeInformationCSV);
    }

//    Read
    @Override
    public List<EmployeeInformationCSV> getAllData() {
        return employeeInformationCSVRepository.getAllData();
    }

    @Override
    public List<EmployeeInformationCSV> getAllEmployeeByOrderGender() {
        return employeeInformationCSVRepository.getAllEmployeeByOrderGender();
    }

    @Override
    public List<EmployeeInformationCSV> getAllEmployeeByOrderName() {
        return employeeInformationCSVRepository.getAllEmployeeByOrderName();
    }

    @Override
    public ByteArrayInputStream downloadDbToCSV() {
        return employeeInformationCSVRepository.downloadDbToCSV();
    }

//    Update
    @Override
    public void editEmployee(EmployeeInformationCSV employeeInformationCSV) {
        employeeInformationCSVRepository.editEmployee(employeeInformationCSV);
    }

//    Delete
    @Override
    public void deleteEmployee(EmployeeInformationCSV employeeInformationCSV) {
        employeeInformationCSVRepository.deleteEmployee(employeeInformationCSV);
    }
}
