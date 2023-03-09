package com.SimpleWeb.SALT.Repository;

import com.SimpleWeb.SALT.domain.konsumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface KonsumenRepository extends JpaRepository<konsumen,Integer> {

    Optional<konsumen>findById(Integer id);
}
