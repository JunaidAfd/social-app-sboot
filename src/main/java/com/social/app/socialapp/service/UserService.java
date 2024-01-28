package com.social.app.socialapp.service;

import com.social.app.socialapp.exceptions.UserException;
import com.social.app.socialapp.models.User;

import java.util.List;

public interface UserService {
    public User registerUser(User user);
    public User findUserById(int userId) throws UserException;
    public User findUserByEmail(String email);
    public User followUser(Integer userId1,Integer userId2) throws UserException;
    public User updateUser(User user,Integer userId) throws UserException;
    public List<User> searchUser(String query);
    public User findUserByJwt(String jwt);
}
