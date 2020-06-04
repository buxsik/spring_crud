package com.rakitov.spring_crud.converter;


import com.rakitov.spring_crud.model.Role;
import com.rakitov.spring_crud.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleConverter implements Converter<String, Role> {

    private final RoleService roleService;


    @Override
    public Role convert(String s) {
        return roleService.getRoleByName(s);
    }
}
