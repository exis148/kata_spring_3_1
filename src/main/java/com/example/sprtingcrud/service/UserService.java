package com.example.sprtingcrud.service;

import com.example.sprtingcrud.dao.UserDao;
import com.example.sprtingcrud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class UserService {



    @Autowired
    private UserDao userDao;

    @Autowired()

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional()
    public void saveUserButton(User user) {
        userDao.saveUserButton(user);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
