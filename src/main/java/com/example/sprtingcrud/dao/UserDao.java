package com.example.sprtingcrud.dao;

import com.example.sprtingcrud.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    List<User> users = new ArrayList<User>();
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void saveUserButton(User user) {
        entityManager.persist(user);
    }


    @Transactional
    public List<User> getUsers() {
        String jpql = "SELECT u FROM User u";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }


    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void updateUser(int id, User updateduser) {

        User userToBeUpdated = getUserById(id);

        if (userToBeUpdated != null) {
            userToBeUpdated.setName(updateduser.getName());
            userToBeUpdated.setSurname(updateduser.getSurname());
            userToBeUpdated.setEmail(updateduser.getEmail());

            entityManager.merge(userToBeUpdated);
        }
    }

 @Transactional
    public void deleteUser(int id) {

        entityManager.remove(getUserById(id));

 }







}