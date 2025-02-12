package com.ibrahim.oracle_db_connectivity.service;

import com.ibrahim.oracle_db_connectivity.entity.User;
import com.ibrahim.oracle_db_connectivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }

    public List<User> findAllById(List<Long> ids){
    return userRepository.findAllById(ids);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void addUsers(List<User> users){
        userRepository.saveAll(users);
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public void updateUser(long id ,User updatedUser){
        userRepository.findById(id).map(user -> {
            if (updatedUser.getFirstName() != null) user.setFirstName(updatedUser.getFirstName());
            if (updatedUser.getLastName() != null) user.setLastName(updatedUser.getLastName());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getPhone() != null) user.setPhone(updatedUser.getPhone());
            System.out.println("Updated email: " + updatedUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));


    }

}
