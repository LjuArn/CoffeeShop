package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.serviceModel.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    void logOut();

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
