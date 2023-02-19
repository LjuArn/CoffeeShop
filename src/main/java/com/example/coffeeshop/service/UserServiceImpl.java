package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.entity.User;
import com.example.coffeeshop.domain.serviceModel.UserServiceModel;
import com.example.coffeeshop.domain.view.UserViewModel;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private  CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);

    }

    @Override
    public void logOut() {
        currentUser.setId(null).setUsername(null);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setId(id).setUsername(username);
    }







    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersAndCountOrdersDes() {
        return userRepository
                .findAllByOrderByOrdersDescending()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrderSet().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
