package com.SimpleWeb.SALT.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="list_sekolah")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListSekolah {

    @Id
    private Integer id;

    private String namaSekolah;
    private String nilaiMinimal;
    private String alamatSekolah;
}
