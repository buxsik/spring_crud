package com.rakitov.spring_crud.service;

import com.rakitov.spring_crud.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleByName(String name);
}
