package com.ibrahim.oracle_db_connectivity.service;

import com.ibrahim.oracle_db_connectivity.DTO.UserCreateDTO;
import com.ibrahim.oracle_db_connectivity.DTO.UserDTO;
import com.ibrahim.oracle_db_connectivity.DTO.UserUpdateDTO;
import com.ibrahim.oracle_db_connectivity.DTOmapper.DTOMapper;
import com.ibrahim.oracle_db_connectivity.entity.User;
import com.ibrahim.oracle_db_connectivity.exception.UserAlreadyExists;
import com.ibrahim.oracle_db_connectivity.exception.UserNotFoundException;
import com.ibrahim.oracle_db_connectivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private DTOMapper dtoMapper;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream().map(DTOMapper::convertToDTO).collect(Collectors.toList());
        if (users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users;
    }

    public Optional<UserDTO> findById(long id){
        return Optional.ofNullable(userRepository.findById(id).map(DTOMapper::convertToDTO).orElseThrow(UserNotFoundException::new));
    }

    public List<UserDTO> findAllById(List<Long> ids){
    List<UserDTO> users = userRepository.findAllById(ids).stream().map(DTOMapper::convertToDTO).collect(Collectors.toList());

    if (users.isEmpty()){
        throw new UserNotFoundException();
    }

    return users;
    }

    public void addUser(UserCreateDTO userCreateDTO){
        if (userRepository.existsByEmail(userCreateDTO.getEmail()))
        {
            throw new UserAlreadyExists();
        }
        User user = DTOMapper.convertToUser(userCreateDTO);
        userRepository.save(user);

    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    public void updateUser(long id, UserUpdateDTO updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        System.out.println(updatedUser.getFirst_name());

        // Only update fields that exist in the DTO
        user.setFirstName(updatedUser.getFirst_name());
        user.setLastName(updatedUser.getLast_name());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(updatedUser.getPassword());

        userRepository.save(user);
    }

}
