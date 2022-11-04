package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;

import com.bsolsystems.employeeLeaveManagementPortal.Entity.EmployeeInformation;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeInformationRepository;
import com.bsolsystems.employeeLeaveManagementPortal.helper.EmployeeInformationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class EmployeeInformationRepositoryImplementation implements EmployeeInformationRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;


    //    Create
    @Override
    public void saveExcelToDB(MultipartFile file) {
        try {
            List<EmployeeInformation> employeeInformation = EmployeeInformationHelper.excelToDB(file.getInputStream());
            System.out.println(employeeInformation);
            for (Iterator<EmployeeInformation> ei = employeeInformation.iterator(); ei.hasNext(); ) {
                EmployeeInformation employeeInformations = ei.next();
//                entityManager.persist(employeeInformations);
//                entityManager.flush();
//                entityManager.clear();
                Query query = entityManager.createNativeQuery("Insert into employeeleavemanagemant.employee_information (first_name, last_name, email, gender, ip_address, mobile, deleted) values (?, ?, ?, ?, ?, ?, ?)")
                        .setParameter(1, employeeInformations.getFirstName())
                        .setParameter(2, employeeInformations.getLastName())
                        .setParameter(3, employeeInformations.getEmail())
                        .setParameter(4, employeeInformations.getGender())
                        .setParameter(5, employeeInformations.getIpAddress())
                        .setParameter(6, employeeInformations.getMobile())
                        .setParameter(7, employeeInformations.isDeleted());
                query.executeUpdate();
            }

        } catch (Exception e) {
            System.err.println("=> "+e);
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    @Override
    public void saveEmployee(EmployeeInformation employeeInformation) {
        try {
//            Query getAll = entityManager.createNativeQuery("select max(employee_id) from employeeleavemanagemant.employee_information");
//            int id = ((BigInteger) getAll.getSingleResult()).intValue();
            Query query = entityManager.createNativeQuery("Insert into employeeleavemanagemant.employee_information (first_name, last_name, email, gender, ip_address, mobile, deleted) values (?, ?, ?, ?, ?, ?, ?)")
//                    .setParameter(1, ++id)
                    .setParameter(1, employeeInformation.getFirstName())
                    .setParameter(2, employeeInformation.getLastName())
                    .setParameter(3, employeeInformation.getEmail())
                    .setParameter(4, employeeInformation.getGender())
                    .setParameter(5, employeeInformation.getIpAddress())
                    .setParameter(6, employeeInformation.getMobile())
                    .setParameter(7, employeeInformation.isDeleted());
            query.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //    Read
    @Override
    public List<EmployeeInformation> getAllEmployee() {
        Query query = entityManager.createQuery("from EmployeeInformation where deleted = false");
        return query.getResultList();
    }

    @Override
    public ByteArrayInputStream getDBToExcel() {
        Query query = entityManager.createQuery("from EmployeeInformation where deleted = false");
        List<EmployeeInformation> employeeInformations = query.getResultList();
        ByteArrayInputStream bais = EmployeeInformationHelper.dbToExcel(employeeInformations);
        return bais;
    }

    @Override
    public List<EmployeeInformation> getAllEmployeeByOrderGender() {
        Query query = entityManager.createQuery("from EmployeeInformation where deleted = false Order By Gender Desc");
        return query.getResultList();
    }

    @Override
    public List<EmployeeInformation> getAllEmployeeByOrderName() {
        Query query = entityManager.createQuery("from EmployeeInformation where deleted = false Order By firstName Asc");
        return query.getResultList();
    }


    //    Update
    @Override
    public void editEmployee(EmployeeInformation employeeInformation) {
        Query query = entityManager.createQuery("update EmployeeInformation set firstName =: fName, lastName =: lName, email =: email, gender =: gender, ipAddress =: ipAddress, mobile =: mobile where employeeId =: empId");
        query.setParameter("fName", employeeInformation.getFirstName());
        query.setParameter("lName", employeeInformation.getLastName());
        query.setParameter("email", employeeInformation.getEmail());
        query.setParameter("gender", employeeInformation.getGender());
        query.setParameter("ipAddress", employeeInformation.getIpAddress());
        query.setParameter("mobile", employeeInformation.getMobile());
        query.setParameter("empId", employeeInformation.getEmployeeId());
        query.executeUpdate();
    }

    //    Delete
    @Override
    public void deleteEmployee(EmployeeInformation employeeInformation) {
        Query query = entityManager.createQuery("update EmployeeInformation set deleted = true where employeeId =: id");
        query.setParameter("id", employeeInformation.getEmployeeId());
        query.executeUpdate();
    }

}
