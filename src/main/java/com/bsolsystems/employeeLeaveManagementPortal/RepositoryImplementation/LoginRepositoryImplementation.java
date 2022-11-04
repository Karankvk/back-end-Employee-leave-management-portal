package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.CreateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.EmployeeLeaveDTO;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdatePasswordDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Encryption.EncryptionDecryption;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Login;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.LoginRepository;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class LoginRepositoryImplementation implements LoginRepository {

    private int previewLoginId;
    private int previewRoleId;
    private int previewEmployeeID;


    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    //Create
    @Override
    public void saveLogin(Login login) {
        login.setPassword(EncryptionDecryption.encrypt(login.getPassword()));
        entityManager.persist(login);
    }

    @Override
    public void createEmployeeWithLogin(CreateEmployeeDTO createEmployeeDTO) {
        Login login = new Login();
        Employee employee = new Employee();
//        To post into login
        createEmployeeDTO.setPassword(EncryptionDecryption.encrypt(createEmployeeDTO.getPassword()));
        login.setUsername(createEmployeeDTO.getUserName());
        login.setPassword(createEmployeeDTO.getPassword());
        login.setRoleRid(createEmployeeDTO.getRoleId());
        entityManager.persist(login);
//        To post into employee
        Query query1 = entityManager.createQuery("from Login where username =: Username");
        query1.setParameter("Username", createEmployeeDTO.getUserName());
        Login loginObj = (Login) query1.getSingleResult();
        int queryLoginID = loginObj.getLoginId();
        employee.seteName(createEmployeeDTO.getEmployeeName());
        employee.seteDesignation(createEmployeeDTO.getDesignation());
        employee.setDoj(createEmployeeDTO.getDateOfJoining());
        employee.setQualification(createEmployeeDTO.getQualification());
        employee.setDob(createEmployeeDTO.getDateOfBirth());
        employee.setContact(createEmployeeDTO.getContact());
        employee.setReporting(createEmployeeDTO.getReporting());
        employee.setLoginId(queryLoginID);
        entityManager.persist(employee);
    }

    //Read
    @Override
    public List<Login> getLogin() {
        Query query = entityManager.createQuery("from Login l where deleted = false and role_rid > 1");
        return query.getResultList();
    }

    @Override
    public Login matchCredential(Login login) {
        String userEnteredPassword = EncryptionDecryption.encrypt(login.getPassword());
        Query query = entityManager.createQuery("from Login l where username = :email");
        query.setParameter("email", login.getUsername());
        Login fromDB = (Login) query.getSingleResult();
        if (userEnteredPassword.equals(fromDB.getPassword())) {
            this.previewLoginId = fromDB.getLoginId();
            this.previewRoleId = fromDB.getRoleRid();
            this.previewEmployeeID = fromDB.getEmployee().getEmployeeId();
            return fromDB;
        } else {
            return null;
        }
    }

    @Override
    public int employeeCount() {
        Query query = entityManager.createQuery("from Login l where role_rid = 3 and deleted = false");
        List<Login> list = query.getResultList();
        return list.size();
    }

    @Override
    public int managerCount() {
        Query query = entityManager.createQuery("from Login l where role_rid = 2 and deleted = false");
        List<Login> list = query.getResultList();
        return list.size();
    }

    @Override
    public List<Employee> getEmployeeDetail() {
        Query  query = entityManager.createQuery("select employee from Login l where Lid =: lid");
        query.setParameter("lid", this.previewLoginId);
        return query.getResultList();
    }

    @Override
    public int employeeRoleId() {
        return this.previewRoleId;
    }

    @Override
    public List<Leave> getSpecificEmployeeLeave() {
        Query query = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid =: employeeId");
        query.setParameter("employeeId", this.previewEmployeeID);
        return query.getResultList();
    }

    @Override
    public int employeePercentage() {
        Query query = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid =: employeeId");
        query.setParameter("employeeId", this.previewEmployeeID);
        List<Leave> employeeLeaves = query.getResultList();
        Query query1 = entityManager.createQuery("from Leave");
        List<Leave> allLeaves= query1.getResultList();
        int percentage =(employeeLeaves.size() * 100) / allLeaves.size();
        return percentage;
    }

    //Update
    @Override
    public void updateRoleId(Login login) {
        Query query = entityManager.createQuery("update Login set role_rid =:RID where Lid =:lid");
        query.setParameter("RID", login.getRoleRid());
        query.setParameter("lid", login.getLoginId());

        query.executeUpdate();
    }

    @Override
    public void checkPassword(UpdatePasswordDTO updatePasswordDTO) {
        System.out.println("Inside checkPassword method");
        String oldEncryptedPassword = EncryptionDecryption.encrypt(updatePasswordDTO.getCurrentPassword());
        Query query = entityManager.createQuery("select password from Login where Lid =: loginId");
        query.setParameter("loginId", updatePasswordDTO.getLoginId());
        if(oldEncryptedPassword.equals(query.getSingleResult())) {
            System.out.println("Going to updatePassword method.");
            updatePassword(updatePasswordDTO.getNewPassword(), updatePasswordDTO.getLoginId());
        }
        else {
            System.out.println("Wrong password");
        }
    }

    @Override
    public void updatePassword(String newPassword, Integer loginID) {
        String encryptedPassword = EncryptionDecryption.encrypt(newPassword);
        Query query = entityManager.createQuery("update Login set password =:psw where Lid =:lid");
        query.setParameter("psw", encryptedPassword);
        query.setParameter("lid", loginID);
        query.executeUpdate();
        System.out.println("Password updated");
    }

    @Override
    public void updateForgetPassword(Login login) {
        String encryptedPassword = EncryptionDecryption.encrypt(login.getPassword());
        Query query = entityManager.createQuery("update Login set password =: pass where Lid =: lid");
        query.setParameter("pass", encryptedPassword);
        query.setParameter("lid", login.getLoginId());
        query.executeUpdate();
    }


    //Delete
    @Override
    public void deleteLoginById(Integer id) {
        Query query = entityManager.createQuery("update Login set deleted = true where Lid =: lid");
        query.setParameter("lid", id);
        query.executeUpdate();
    }
}
