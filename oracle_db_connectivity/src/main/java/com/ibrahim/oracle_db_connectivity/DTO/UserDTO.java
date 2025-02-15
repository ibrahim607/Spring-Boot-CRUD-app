package com.ibrahim.oracle_db_connectivity.DTO;

public record UserDTO(
        long id,
        String first_name,
        String last_name,
        String email,
        String phone
) {

}
