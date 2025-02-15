package com.ibrahim.oracle_db_connectivity.controller;

import com.ibrahim.oracle_db_connectivity.DTO.UserDTO;
import com.ibrahim.oracle_db_connectivity.entity.User;
import com.ibrahim.oracle_db_connectivity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> findById(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping({"/find-all"})
    public List<UserDTO> findAllById(@RequestBody List<Long> ids){
        return userService.findAllById(ids);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
         userService.addUser(user);
    }

    @PostMapping("/add")
    public void addUsers(@RequestBody List<User> users){
        userService.addUsers(users);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id ,User updatedUser){userService.updateUser(id,updatedUser);
    }

}
