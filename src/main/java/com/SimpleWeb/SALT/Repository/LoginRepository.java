package com.SimpleWeb.SALT.Repository;

import com.SimpleWeb.SALT.domain.konsumen;
import com.SimpleWeb.SALT.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM `login` WHERE username = :username AND password = :password ")
    Optional<Login>findLoginRoles(@Param("username") String username,
                                  @Param("password") String password);
}
