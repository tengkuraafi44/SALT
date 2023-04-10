package com.SimpleWeb.SALT.DTO;

import com.SimpleWeb.SALT.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResponseSekolah implements Serializable, ResponseData {

    private String Nama;
    private String NilaiSiswa;
    List<InquiryData> ListSekolah;

}
