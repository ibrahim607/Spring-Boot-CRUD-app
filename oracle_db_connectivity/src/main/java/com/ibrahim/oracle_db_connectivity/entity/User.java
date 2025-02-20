package com.ibrahim.oracle_db_connectivity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.BatchSize;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 30 , min = 2)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 30 , min = 2)
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "password" , nullable = false)
    private String password;

}
