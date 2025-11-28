package com.example.login_mediflow;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @NotBlank @Size(min = 1, max = 20)
    private String userName;
    @NotBlank @Size(min = 1, max = 20)
    private String password;
    @NotBlank @Size(min = 1, max = 20)
    private String role;
}
