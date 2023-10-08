package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.entity.User;
import com.example.coffeeshop.domain.serviceModel.UserServiceModel;
import com.example.coffeeshop.domain.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    void logOut();

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);


    User findById(Long id);

    List<UserViewModel> findAllUsersAndCountOrdersDes();

    boolean isNameExistMetod(String username);
}
