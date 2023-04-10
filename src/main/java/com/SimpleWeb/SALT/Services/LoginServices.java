package com.SimpleWeb.SALT.Services;

import com.SimpleWeb.SALT.DTO.ResponseLogin;
import com.SimpleWeb.SALT.Exception;
import com.SimpleWeb.SALT.Repository.LoginRepository;
import com.SimpleWeb.SALT.domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LoginServices {

    @Autowired
    LoginRepository loginRepository;

    public ResponseLogin login(String username,
                               String password) {

        String status;
        String role;
        final Login checkLogin = loginRepository.findLoginRoles(username, password)
                .orElseThrow(() -> new Exception("4004", "Akun tidak ditemukan"));

        if (checkLogin != null) {
            status = "Success";
            role = checkLogin.getRole();
        }else{
            status = "failed";
            role = "ERROR";
        }
        return ResponseLogin.builder()
                .status(status)
                .roles(role)
                .build();
    }
}
