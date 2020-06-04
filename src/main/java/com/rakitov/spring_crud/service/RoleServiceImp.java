package com.rakitov.spring_crud.service;

import com.rakitov.spring_crud.dao.RoleDaoImp;
import com.rakitov.spring_crud.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService{

    private final RoleDaoImp roleDao;

    @Transactional
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
