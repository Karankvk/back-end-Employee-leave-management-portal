package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformationCSV;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeInformationCSVRepository;
import com.bsolsystems.employeeLeaveManagementPortal.helper.EmployeeInformationCSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class EmployeeInformationCSVRepositoryImplementation implements EmployeeInformationCSVRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    //    Create
    @Override
    public void saveCsvToDb(MultipartFile file) {
        try {
            List<EmployeeInformationCSV> employeeInformationCSVS = EmployeeInformationCSVHelper.csvToDb(file.getInputStream());
            for (Iterator<EmployeeInformationCSV> eicsv = employeeInformationCSVS.iterator(); eicsv.hasNext(); ) {
                EmployeeInformationCSV employeeInformationCSV = eicsv.next();
                Query query = entityManager.createNativeQuery("Insert into employeeleavemanagemant.employee_information_csv (first_name, last_name, email, gender, ip_address, mobile, deleted) values (?, ?, ?, ?, ?, ?, ?)").setParameter(1, employeeInformationCSV.getFirst_name()).setParameter(2, employeeInformationCSV.getLast_name()).setParameter(3, employeeInformationCSV.getEmail()).setParameter(4, employeeInformationCSV.getGender()).setParameter(5, employeeInformationCSV.getIpAddress()).setParameter(6, employeeInformationCSV.getMobile()).setParameter(7, employeeInformationCSV.isDeleted());
                query.executeUpdate();
            }
        } catch (IOException e) {
            System.err.println("=> " + e);
            throw new RuntimeException("fail to store CSV data: " + e.getMessage());
        }
    }

    @Override
    public void saveEmployee(EmployeeInformationCSV employeeInformationCSV) {
        try {
            Query query = entityManager.createNativeQuery("Insert into employeeleavemanagemant.employee_information_csv (first_name, last_name, email, gender, ip_address, mobile, deleted) values (?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, employeeInformationCSV.getFirst_name())
                    .setParameter(2, employeeInformationCSV.getLast_name())
                    .setParameter(3, employeeInformationCSV.getEmail())
                    .setParameter(4, employeeInformationCSV.getGender())
                    .setParameter(5, employeeInformationCSV.getIpAddress())
                    .setParameter(6, employeeInformationCSV.getMobile())
                    .setParameter(7, employeeInformationCSV.isDeleted());
            query.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //    Read
    @Override
    public List<EmployeeInformationCSV> getAllData() {
        Query query = entityManager.createQuery("from EmployeeInformationCSV where deleted = false");
        return query.getResultList();
    }

    @Override
    public List<EmployeeInformationCSV> getAllEmployeeByOrderGender() {
        Query query = entityManager.createQuery("from EmployeeInformationCSV where deleted = false Order By Gender Desc");
        return query.getResultList();
    }

    @Override
    public List<EmployeeInformationCSV> getAllEmployeeByOrderName() {
        Query query = entityManager.createQuery("from EmployeeInformationCSV where deleted = false Order By first_name Asc");
        return query.getResultList();
    }

    @Override
    public ByteArrayInputStream downloadDbToCSV() {
        List<EmployeeInformationCSV> employeeInformationCSVS = getAllData();
        ByteArrayInputStream in = EmployeeInformationCSVHelper.dbToCSV(employeeInformationCSVS);
        return in;
    }

//    Update

    @Override
    public void editEmployee(EmployeeInformationCSV employeeInformationCSV) {
        Query query = entityManager.createQuery("update EmployeeInformationCSV set first_name =: fName, last_name =: lName, email =: email, gender =: gender, ipAddress =: ipAddress, mobile =: mobile where employeeId =: empId");
        query.setParameter("fName", employeeInformationCSV.getFirst_name());
        query.setParameter("lName", employeeInformationCSV.getLast_name());
        query.setParameter("email", employeeInformationCSV.getEmail());
        query.setParameter("gender", employeeInformationCSV.getGender());
        query.setParameter("ipAddress", employeeInformationCSV.getIpAddress());
        query.setParameter("mobile", employeeInformationCSV.getMobile());
        query.setParameter("empId", employeeInformationCSV.getEmployeeId());
        query.executeUpdate();
    }

    //    Delete
    @Override
    public void deleteEmployee(EmployeeInformationCSV employeeInformationCSV) {
        Query query = entityManager.createQuery("update EmployeeInformationCSV set deleted = true where employeeId =: id");
        query.setParameter("id", employeeInformationCSV.getEmployeeId());
        query.executeUpdate();
    }
}
