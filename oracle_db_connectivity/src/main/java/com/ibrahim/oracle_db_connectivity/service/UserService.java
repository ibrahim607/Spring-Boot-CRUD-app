package com.ibrahim.oracle_db_connectivity.service;

import com.ibrahim.oracle_db_connectivity.DTO.UserDTO;
import com.ibrahim.oracle_db_connectivity.entity.User;
import com.ibrahim.oracle_db_connectivity.mapper.UserDTOMapper;
import com.ibrahim.oracle_db_connectivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserService(UserDTOMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(long id){
        return userRepository.findById(id).map(userDTOMapper);
    }

    public List<UserDTO> findAllById(List<Long> ids){
    return userRepository.findAllById(ids).stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public void addUser(User user){
        userRepository.save(user);
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
