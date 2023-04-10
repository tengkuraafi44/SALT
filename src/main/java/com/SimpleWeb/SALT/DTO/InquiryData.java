package com.SimpleWeb.SALT.DTO;

import com.SimpleWeb.SALT.Response;
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
public class InquiryData implements Serializable, ResponseData {
    private String id;
    private String NamaSekolah;
    private String NilaiMinimalSekolah;
    private String AlamatSekolah;
}
