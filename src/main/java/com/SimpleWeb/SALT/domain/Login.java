package com.SimpleWeb.SALT.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    private Integer id;

    private String username;
    private String password;
    private String role;
}
