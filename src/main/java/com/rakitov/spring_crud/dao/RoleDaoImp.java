package com.rakitov.spring_crud.dao;

import com.rakitov.spring_crud.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@AllArgsConstructor
public class RoleDaoImp {

    private final EntityManager entityManager;


    public List<Role> getAllRole() {
        List<Role> roleList = entityManager.createQuery("from Role", Role.class)
                .getResultList();
        return roleList;
    }


    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from Role role where role.name=:thisName", Role.class)
                .setParameter("thisName", name)
                .getSingleResult();
    }
}
