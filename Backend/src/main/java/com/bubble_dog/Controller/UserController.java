package com.bubble_dog.Controller;

//import java.util.List;

import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubble_dog.Models.UserModel;
import com.bubble_dog.Services.StatusService;
import com.bubble_dog.Services.UserServices;
//import com.bubble_dog.repository.UserRepository;

@RestController
@RequestMapping("usuario")
public class UserController {
    

    // @Autowired(required = true)
    // UserRepository userRepository;


    // @PostMapping("/users/register")
    // public StatusService registerUser(@Valid @RequestBody UserModel newUser) {
    //     List<UserModel> users = userRepository.findAll();

    //     System.out.println("Usuario Nuevo" + newUser.toString());
        
    //     for(UserModel user: users) {
    //         System.out.println("Usuario registrado" + newUser.toString());
            
    //         if(user.equals(newUser)){
    //             System.out.println("Usuario ya existe!");
    //             return StatusService.USER_ALREADY_EXISTS;
    //         } 
    //     }
    //     userRepository.save(newUser);
    //     return StatusService.USER_CREATED_SUCCESSFULLY;
    // }

    
    // @PostMapping("/users/login")
    // public StatusService loginUser(@Valid @RequestBody UserModel user) {
    //     List<UserModel> users = userRepository.findAll();

    //     for (UserModel userModel : users) {
    //         if(userModel.equals(user)) {
    //             user.setLoggedIn(true);
    //             userRepository.save(user);
    //             return StatusService.SUCCESS;
    //         }
            
    //     }
    //     return StatusService.INCORRECT_DATA;
    // }

    // @PostMapping("/users/logout")
    // public StatusService logUserOut(@Valid @RequestBody UserModel user) {
    //     List<UserModel> users = userRepository.findAll();
    //     for (UserModel other : users) {
    //         if (other.equals(user)) {
    //             user.setLoggedIn(false);
    //             userRepository.save(user);
    //             return StatusService.SUCCESS;
    //         }
    //     }
    //     return StatusService.FAILURE;
    // }

    // @DeleteMapping("/users/all")
    // public StatusService deleteUsers() {
    //     userRepository.deleteAll();
    //     return StatusService.SUCCESS;
    // }

    private UserServices userServices;


    public UserController() {
        userServices = new UserServices();
    }

    @PostMapping("/register")
    public StatusService create(@Valid @RequestBody UserModel newUser) {
        return userServices.create(newUser);
    }
}
