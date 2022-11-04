package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.DTO.DataTransferObjects;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.UpdateEmployeeDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.EmployeeRepository;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImplementation implements EmployeeRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    //Save service
    @Override
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    //Get service
    @Override
    public List<Employee> getEmployee() {
        Query query = entityManager.createQuery("from Employee e where deleted = false and login_id in (from Login l where role_rid = 3 and role_rid != 1)");
        return query.getResultList();
    }

    @Override
    public List<Employee> getManager() {
        Query query = entityManager.createQuery("from Employee e where deleted = false and login_id in (from Login l where role_rid = 2 and role_rid != 1)");
        return query.getResultList();
    }

    @Override
    public List<Employee> getEmployeeById(Integer EID) {
        Query query = entityManager.createQuery("from Employee e where eid =: EID and deleted = false");
        query.setParameter("EID", EID);
        return query.getResultList();
    }

    @Override
    public List<Employee> getDeletedEmployee() {
        Query query = entityManager.createQuery("from Employee e where deleted = true");
        return query.getResultList();
    }

    @Override
    public List<DataTransferObjects> getEmployeeLoginRole() {
        List<DataTransferObjects> dto = entityManager.createNativeQuery("select e.name as name, e.designation as designation, e.date_of_joining as doj, e.qualification as qualification, e.date_of_birth as dob, e.contact as contact, e.reporting as reporting, l.username as username, l.Lid as loginId, l.role_rid as roleId, r.roles as role from employee_details e Inner join login_detail l on e.login_id = l.Lid Inner join role_detail r on l.role_rid = r.rid where e.deleted = false and l.role_rid != 1").unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(DataTransferObjects.class)).getResultList();
        return dto;
    }

    //Update service
    @Override
    public void updateEmployee(Employee employee) {
        Query query = entityManager.createQuery("update Employee set name =: name, designation =: Edesignation, date_of_joining =: Edoj, qualification =: Equali, date_of_birth =: Edob, contact =: Econtact, reporting =: Ereport where eid =: employeeId");
        query.setParameter("eName", employee.geteName());
        query.setParameter("Edesignation", employee.geteDesignation());
        query.setParameter("Edoj", employee.getDoj());
        query.setParameter("Equali", employee.getQualification());
        query.setParameter("Edob", employee.getDob());
        query.setParameter("Econtact", employee.getContact());
        query.setParameter("Ereport", employee.getReporting());
        query.setParameter("employeeId", employee.getEmployeeId());

        query.executeUpdate();
    }

    @Override
    public void updateEmployeeWithLogin(UpdateEmployeeDTO updateEmployeeDTO) {
        Query query = entityManager.createQuery("update Login set role_rid =:RID where Lid =:lid");
        query.setParameter("RID", updateEmployeeDTO.getRoleId());
        query.setParameter("lid", updateEmployeeDTO.getLoginId());
        query.executeUpdate();

        Query query1 = entityManager.createQuery("update Employee set name =: eName, designation =: Edesignation, date_of_joining =: Edoj, qualification =: Equali, date_of_birth =: Edob, contact =: Econtact, reporting =: Ereport where login_id =: employeeLoginId");
        query1.setParameter("eName", updateEmployeeDTO.getName());
        query1.setParameter("Edesignation", updateEmployeeDTO.getDesignation());
        query1.setParameter("Edoj", updateEmployeeDTO.getDoj());
        query1.setParameter("Equali", updateEmployeeDTO.getQualification());
        query1.setParameter("Edob", updateEmployeeDTO.getDob());
        query1.setParameter("Econtact", updateEmployeeDTO.getContact());
        query1.setParameter("Ereport", updateEmployeeDTO.getReporting());
        query1.setParameter("employeeLoginId", updateEmployeeDTO.getLoginId());
        query1.executeUpdate();
    }

    //Delete service
    @Override
    public void deleteEmployee(Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Query query = entityManager.createQuery("update Employee set deleted = true, resignation_date =: resignDate where login_id =: employeeLoginId");
        query.setParameter("resignDate", dtf.format(now));
        query.setParameter("employeeLoginId", id);
        query.executeUpdate();

        Query query1 = entityManager.createQuery("update Login set deleted = true where Lid =: loginId");
        query1.setParameter("loginId", id);
        query1.executeUpdate();
    }
}
