package com.example.coffeeshop.web;


import com.example.coffeeshop.domain.binding.UserLoginBindingModel;
import com.example.coffeeshop.domain.binding.UserRegisterBindingModel;
import com.example.coffeeshop.domain.serviceModel.UserServiceModel;
import com.example.coffeeshop.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }


    @PostMapping("/register")
    public String registerConfirmPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())
        ) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";

        }

        boolean isNameExist = userService.isNameExistMetod(userRegisterBindingModel.getUsername());

        if(isNameExist){
            redirectAttributes.addFlashAttribute("isNameExist", true)
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",
                            bindingResult);
            return "redirect:register";
        }


        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

//_______________________________________________________________________________________

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("isNotFound")) {
            model.addAttribute("isNotFound", false);
        }
        return "login";
    }


    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }


    @PostMapping("/login")
    public String loginConfirmPost(@Valid UserLoginBindingModel userLoginBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        UserServiceModel user = userService
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());


        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("isNotFound", true)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            return "redirect:login";
        }

        userService.loginUser(user.getId(), user.getUsername());

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logOut() {
        userService.logOut();
        return "redirect:/";
    }

}

