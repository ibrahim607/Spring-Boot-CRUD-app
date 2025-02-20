package com.ibrahim.oracle_db_connectivity.DTOmapper;

import com.ibrahim.oracle_db_connectivity.DTO.UserCreateDTO;
import com.ibrahim.oracle_db_connectivity.DTO.UserDTO;
import com.ibrahim.oracle_db_connectivity.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {
    public static UserDTO convertToDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .first_name(user.getFirstName())
                .last_name(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static User convertToUser(UserCreateDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirst_name());
        user.setLastName(dto.getLast_name());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword()); 
        return user;
    }
}
