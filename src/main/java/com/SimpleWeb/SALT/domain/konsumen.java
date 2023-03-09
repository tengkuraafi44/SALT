package com.SimpleWeb.SALT.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="konsumen")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class konsumen {

    @Id
    private Integer id;

    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;

    private LocalDateTime tgl_registrasi;
    private String status;
}
