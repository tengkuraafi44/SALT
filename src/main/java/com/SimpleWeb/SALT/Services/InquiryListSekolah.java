package com.SimpleWeb.SALT.Services;

import com.SimpleWeb.SALT.DTO.InquiryData;
import com.SimpleWeb.SALT.DTO.InquiryResponseSekolah;
import com.SimpleWeb.SALT.Repository.ListSekolahRepository;
import com.SimpleWeb.SALT.domain.ListSekolah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class InquiryListSekolah {
    @Autowired
    ListSekolahRepository listSekolahRepository;

    public InquiryResponseSekolah findSekolah(final String namaSiswa,
                                              final Float nilai) throws Exception {

        if(nilai > 100){
            throw new Exception("Input Nilai Error");
        }

        List<InquiryData> dataSekolah = new ArrayList<>();

        List<ListSekolah> data = listSekolahRepository.findSekolahByNilai(nilai);

        for (ListSekolah inquiryData : data){

            InquiryData kumpulanData =InquiryData.builder()
                    .id(inquiryData.getId().toString())
                    .NamaSekolah(inquiryData.getNamaSekolah())
                    .NilaiMinimalSekolah(inquiryData.getNilaiMinimal())
                    .AlamatSekolah(inquiryData.getAlamatSekolah())
                    .build();
            dataSekolah.add(kumpulanData);
        }

        return InquiryResponseSekolah.builder()
                .Nama(namaSiswa)
                .NilaiSiswa(nilai.toString())
                .ListSekolah(dataSekolah)
                .build();
    }
}
