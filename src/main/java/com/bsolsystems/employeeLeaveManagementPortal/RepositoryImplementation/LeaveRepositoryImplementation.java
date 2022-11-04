package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.Constants.Constants;
import com.bsolsystems.employeeLeaveManagementPortal.Constants.DayCalculation;
import com.bsolsystems.employeeLeaveManagementPortal.DTO.EmployeeLeaveDTO;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Employee;
import com.bsolsystems.employeeLeaveManagementPortal.Entity.Leave;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.LeaveRepository;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

@Repository
@Transactional
public class LeaveRepositoryImplementation implements LeaveRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    Constants constants = new Constants();

    @Override
    public Leave saveLeave(Leave leave) {

        long leaveApplied = DayCalculation.dayCalculation(leave.getStartDate(), leave.getEndDate());
        Query query = entityManager.createQuery("Select leaveCount from Employee where deleted = false and employeeId=:EmployeeId");
        query.setParameter("EmployeeId", leave.getEmployeeID());
        int leaveUsed = (int)query.getSingleResult();
        if( (leaveUsed + leaveApplied) <= constants.leaveLimit) {
            entityManager.persist(leave);
            leaveUsed += leaveApplied;
            Query query1 = entityManager.createQuery("update Employee set leaveCount =: leaveUsed where employeeId =: EmployeeId");
            query1.setParameter("leaveUsed", leaveUsed);
            query1.setParameter("EmployeeId", leave.getEmployeeID());
            query1.executeUpdate();
            System.out.println("Enter if body");
            return leave;
        }
        else {
            System.out.println("Enter else body");
            return null;
        }
    }

    @Override
    public List<Leave> getLeave() {
        Query query = entityManager.createQuery("from Leave where revoked = 'd'");
        return query.getResultList();
    }

    @Override
    public List<EmployeeLeaveDTO> getManagerLeave() {
        List<EmployeeLeaveDTO> dto= entityManager.createNativeQuery("Select l.leid as leaveId, l.start_date as startDate, l.end_date as endDate, l.leave_type as leaveType, l.reason as reason, l.status as status, e.name as employeeName from leave_detail l Inner Join employee_details e on l.employee_eid = e.eid Inner Join login_detail a on e.login_id = a.Lid where l.revoked != 'd' and a.role_rid = 2").unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(EmployeeLeaveDTO.class)).getResultList();
        return dto;
    }

    @Override
    public List<EmployeeLeaveDTO> getEmployeeLeave() {
        List<EmployeeLeaveDTO> dto= entityManager.createNativeQuery("Select l.leid as leaveId, l.start_date as startDate, l.end_date as endDate, l.leave_type as leaveType, l.reason as reason, l.status as status, e.name as employeeName from leave_detail l Inner Join employee_details e on l.employee_eid = e.eid Inner Join login_detail a on e.login_id = a.Lid where l.revoked != 'd' and a.role_rid = 3").unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(EmployeeLeaveDTO.class)).getResultList();
        return dto;
    }

    @Override
    public int countLeaveApproved() {
        Query query = entityManager.createQuery("from Leave l where status = 'Approved'");
        List<Leave> list = query.getResultList();
        return list.size();
    }

    @Override
    public int countLeaveNotApproved() {
        Query query = entityManager.createQuery("from Leave l where status = 'Un-Approved'");
        List<Leave> list = query.getResultList();
        return list.size();
    }

    @Override
    public int countManagerLeave() {
        Query query = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid in (from Employee e where login_id in (from Login r where role_rid = 2))");
        List<Leave> list = query.getResultList();
        return list.size();
    }

    @Override
    public int countEmployeeLeaves() {
        Query query = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid in (from Employee e where login_id in (from Login r where role_rid = 3))");
        List<Leave> list = query.getResultList();
        return list.size();
    }

    @Override
    public int[] arrayEmployeeManagerCount() {
        Query employeeCount = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid in (from Employee e where login_id in (from Login r where role_rid = 3))");
        Query managerCount = entityManager.createQuery("from Leave l where revoked = 'n' and employee_eid in (from Employee e where login_id in (from Login r where role_rid = 2))");
        Query allLeave = entityManager.createQuery("from Leave l");
        List<Leave> list = employeeCount.getResultList();
        List<Leave> list1 = managerCount.getResultList();
        List<Leave> allLeaveCount = allLeave.getResultList();
        int employeePercentage = (list.size() * 100) / allLeaveCount.size();
        int managerPercentage = (list1.size() * 100) / allLeaveCount.size();
        int arr[] = {managerPercentage, employeePercentage};
        return arr;
    }

    @Override
    public List<EmployeeLeaveDTO> getEmployeeRevokeLeave() {
        List<EmployeeLeaveDTO> dto= entityManager.createNativeQuery("Select l.leid as leaveId, l.start_date as startDate, l.end_date as endDate, l.leave_type as leaveType, l.reason as reason, l.status as status, e.name as employeeName from leave_detail l Inner Join employee_details e on l.employee_eid = e.eid Inner Join login_detail a on e.login_id = a.Lid where l.revoked = 'd' and a.role_rid = 3").unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(EmployeeLeaveDTO.class)).getResultList();
        return dto;
    }

    @Override
    public List<EmployeeLeaveDTO> getManagerRevokeLeave() {
        List<EmployeeLeaveDTO> dto= entityManager.createNativeQuery("Select l.leid as leaveId, l.start_date as startDate, l.end_date as endDate, l.leave_type as leaveType, l.reason as reason, l.status as status, e.name as employeeName from leave_detail l Inner Join employee_details e on l.employee_eid = e.eid Inner Join login_detail a on e.login_id = a.Lid where l.revoked = 'd' and a.role_rid = 2").unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(EmployeeLeaveDTO.class)).getResultList();
        return dto;
    }

    @Override
    public void updateLeave(Leave leave) {
        Query query = entityManager.createQuery("update Leave set startDate =: startDATE, endDate =: endDATE, leaveType =: leaveTYPE, reason =: REASON where leaveId =: leaveID");
        query.setParameter("startDATE", leave.getStartDate());
        query.setParameter("endDATE", leave.getEndDate());
        query.setParameter("leaveTYPE", leave.getLeaveType());
        query.setParameter("REASON", leave.getReason());
        query.setParameter("leaveID", leave.getLeaveId());

        query.executeUpdate();
    }

    @Override
    public void updateLeaveStatusApproved(Leave leave) {
        Query query = entityManager.createQuery("update Leave set status = 'Approved' where leaveId =: leaveID");
        query.setParameter("leaveID", leave.getLeaveId());
        query.executeUpdate();
    }

    @Override
    public void updateLeaveStatusRejected(Leave leave) {
        Query query = entityManager.createQuery("update Leave set status = 'Rejected' where leaveId =: leaveID");
        query.setParameter("leaveID", leave.getLeaveId());
        query.executeUpdate();

        Query query1 = entityManager.createQuery("from Employee where employeeId = (select l.employeeID from Leave l where l.leaveId =: id)");
        query1.setParameter("id", leave.getLeaveId());
        Employee employeeObject = (Employee) query1.getSingleResult();
        int count = employeeObject.getLeaveCount();
        int leaveCount = (int)DayCalculation.dayCalculation(leave.getStartDate(), leave.getEndDate());
        int updateLeaveCount = count - leaveCount;
        Query query2 = entityManager.createQuery("update Employee e set e.leaveCount =: count where e.employeeId = (select l.employeeID from Leave l where l.leaveId =: id)");
        query2.setParameter("count", updateLeaveCount);
        query2.setParameter("id", leave.getLeaveId());
        query2.executeUpdate();
    }

    @Override
    public void revokeLeave(Leave leave) {
        Query query = entityManager.createQuery("update Leave set revoked = 'd' where leaveId =: leaveID");
        query.setParameter("leaveID", leave.getLeaveId());
        query.executeUpdate();

        Query query1 = entityManager.createQuery("from Employee where employeeId =: EID");
        query1.setParameter("EID", leave.getEmployeeID());
        Employee employeeObject = (Employee) query1.getSingleResult();
        int count = employeeObject.getLeaveCount();
        int leaveCount = (int)DayCalculation.dayCalculation(leave.getStartDate(), leave.getEndDate());
        int updateLeaveCount = count - leaveCount;
        Query query2 = entityManager.createQuery("update Employee e set e.leaveCount =: count where e.employeeId =: id");
        query2.setParameter("count", updateLeaveCount);
        query2.setParameter("id", leave.getEmployeeID());
        query2.executeUpdate();
    }

}
