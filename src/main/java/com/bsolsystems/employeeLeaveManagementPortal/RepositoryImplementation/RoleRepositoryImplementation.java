package com.bsolsystems.employeeLeaveManagementPortal.RepositoryImplementation;
/**
 * @author karanVishwakarma
 * @organization BSOL systems
 */

import com.bsolsystems.employeeLeaveManagementPortal.Entity.Role;
import com.bsolsystems.employeeLeaveManagementPortal.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleRepositoryImplementation implements RoleRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        Query query = entityManager.createQuery("select r from Role r");
        return query.getResultList();
    }
}
