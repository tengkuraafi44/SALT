package com.SimpleWeb.SALT.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InquiryDataDTO implements Serializable{
    private String id;
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private String tgl_registrasi;
    private String status;
}
