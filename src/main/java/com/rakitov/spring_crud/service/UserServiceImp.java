package com.rakitov.spring_crud.service;

import com.rakitov.spring_crud.dao.RoleDaoImp;
import com.rakitov.spring_crud.dao.UserDaoImp;
import com.rakitov.spring_crud.model.Role;
import com.rakitov.spring_crud.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {


    private final UserDaoImp userDao;
    private final RoleDaoImp roleDao;
    private final PasswordEncoder noOpPass;

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public void createUser(User user, String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            Role roleFromDB = roleDao.getRoleByName(role);
            roleSet.add(roleFromDB);
        }
        user.setRole(roleSet);
        user.setPassword(noOpPass.encode(user.getPassword()));
        userDao.createUser(user);
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user, String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            Role roleFromDB = roleDao.getRoleByName(role);
            roleSet.add(roleFromDB);
        }
        user.setRole(roleSet);
        user.setPassword(noOpPass.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    public User findUserByUsername(String usermame) { return userDao.findUserByUserName(usermame); }
}
