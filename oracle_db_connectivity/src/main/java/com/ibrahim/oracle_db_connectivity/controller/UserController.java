package com.ibrahim.oracle_db_connectivity.controller;

import com.ibrahim.oracle_db_connectivity.DTO.UserCreateDTO;
import com.ibrahim.oracle_db_connectivity.DTO.UserDTO;
import com.ibrahim.oracle_db_connectivity.DTO.UserUpdateDTO;
import com.ibrahim.oracle_db_connectivity.entity.User;
import com.ibrahim.oracle_db_connectivity.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
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
    public List<UserDTO> findAllById(@Valid @RequestBody List<Long> ids){
        return userService.findAllById(ids);
    }

    @PostMapping
    public void addUser(@Valid @RequestBody UserCreateDTO user){
         userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id ,@Valid @RequestBody UserUpdateDTO updatedUser){userService.updateUser(id,updatedUser);
    }

}
