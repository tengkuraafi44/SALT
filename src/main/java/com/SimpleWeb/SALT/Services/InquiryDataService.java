package com.SimpleWeb.SALT.Services;

import com.SimpleWeb.SALT.DTO.InquiryDataDTO;
import com.SimpleWeb.SALT.DTO.InquiryResponse;
import com.SimpleWeb.SALT.Repository.KonsumenRepository;
import com.SimpleWeb.SALT.domain.konsumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class InquiryDataService {
    @Autowired
    KonsumenRepository konsumenRepository;

    List<InquiryDataDTO> listData = new ArrayList<>();

    DateTimeFormatter formatHead = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
    public InquiryResponse findDataByParam(final String id) {

        konsumen  dataKonsumen = konsumenRepository.findById(Integer.valueOf(id))
                .orElse(null);

        String tanggal = formatHead.format(dataKonsumen.getTgl_registrasi());

        InquiryDataDTO dataDTO = InquiryDataDTO.builder()
                .id(id)
                .nama(dataKonsumen.getNama())
                .alamat(dataKonsumen.getAlamat())
                .kota(dataKonsumen.getKota())
                .provinsi(dataKonsumen.getProvinsi())
                .tgl_registrasi(tanggal)
                .status(dataKonsumen.getStatus())
                .build();
        listData.add(dataDTO);
        return new InquiryResponse().builder()
                .accountInformation(listData)
                .build();
    }
}
