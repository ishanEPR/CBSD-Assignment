package com.example.userservice.controller;

import com.example.userservice.DTO.RequiredResponseAsset;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

//    @GetMapping()
//    public String say()
//    {
//        return "Hello ishan";
//    }

    @PostMapping()
    public User saveUser(@RequestBody User user)
    {
        log.info("saveUser method in UserController(save the user Data)");
       return userService.saveUser(user);
    }

    @GetMapping("")
    public List<User> displayUserData()
    {
        log.info("displayUserData method in UserController (display the all the list of users)");
        return userService.displayUserData();
    }

    @GetMapping("{id}")
    public Optional<User> getUserData(@PathVariable int id)
    {
        log.info("getUserData method in UserController (display the a user data)");
        return userService.getUserData(id);
    }

    //call from user service(get the list of assets)
    @GetMapping("/id/{id}")
    public List<User> findByAssetId(@PathVariable int id)
    {
        log.info("findByAssetId method in UserController (call from asset service(get the list of users)");
        return userService.findByAssetId(id);
    }



//    @GetMapping("/getAssetDetails/id/{id}")
//    public RequiredResponseAsset getAssetsData(@PathVariable int id)
//    {
//        return userService.getAssetsData(id);
//    }
}
