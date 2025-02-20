package com.ibrahim.oracle_db_connectivity.DTO;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateDTO{
    @Size(max = 30,min = 2, message = "Last name must be between 2 and 30 characters")
    @NotBlank(message = "First name is required")
    private String first_name;
    @Size(max = 30,min = 2 , message = "Last name must be between 2 and 30 characters")
    @NotBlank(message = "Last name is required")
    private String last_name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private  String email;
    @NotBlank(message = "Phone is required")
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must be 10 to 15 digits and can start with +"
    )
    private  String phone;
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;
}
