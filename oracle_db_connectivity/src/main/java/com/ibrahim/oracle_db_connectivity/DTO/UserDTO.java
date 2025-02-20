package com.ibrahim.oracle_db_connectivity.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;


@Getter
@Setter
@Builder
public class UserDTO{
    @Id
    private long id;
    @Size(max = 30,min = 2)
    @NotBlank(message = "First name is required")
    private String first_name;
    @Size(max = 30,min = 2)
    @NotBlank(message = "Last name is required")
    private String last_name;
    @NotBlank(message = "Email is required")
    @Email
    private  String email;
    @NotBlank(message = "Phone is required")
    private  String phone;
}
