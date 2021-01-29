package com.kang.restcont.controller;


import com.kang.restcont.model.User;
import com.kang.restcont.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("admin/add")
    public User addUser(@RequestBody User user){
        userService.insert(user);

        return user;
    }


    @PostMapping("admin/edit")
    public User editUser(@RequestBody User user) {
        userService.update(user);

        return user;
    }


    @PutMapping("admin/delete")
    public String deleteUser(String id){
        userService.deleteUser(Integer.parseInt(id));

        return id;
    }

}
