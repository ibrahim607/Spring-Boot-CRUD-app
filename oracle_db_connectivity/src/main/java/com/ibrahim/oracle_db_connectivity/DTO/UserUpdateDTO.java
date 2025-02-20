package com.ibrahim.oracle_db_connectivity.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserUpdateDTO {
    @Size(max = 30, min = 2, message = "First name must be between 2 and 30 characters")
    private String first_name;

    @Size(max = 30, min = 2, message = "Last name must be between 2 and 30 characters")
    private String last_name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must be 10 to 15 digits and can start with +"
    )
    private String phone;

    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;
}