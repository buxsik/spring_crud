package com.rakitov.spring_crud.dao;

import com.rakitov.spring_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class UserDaoImp {


    @Autowired
    private EntityManager entityManager;



    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }


    public void createUser(User user) {
        entityManager.persist(user);
    }


    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    public void updateUser(User user) {
        entityManager.merge(user);
    }


    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    public User findUserByUserName(String userName) {
        return entityManager.createQuery("select user from User user where user.username=:thisUsername", User.class)
                .setParameter("thisUsername", userName)
                .getSingleResult();
    }
}
