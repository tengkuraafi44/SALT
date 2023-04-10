package com.SimpleWeb.SALT.Repository;

import com.SimpleWeb.SALT.domain.ListSekolah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSekolahRepository extends JpaRepository <ListSekolah,Integer>{

        @Query(nativeQuery = true,value = "SELECT * FROM `list_sekolah` WHERE nilai_minimal < :nilaiMin or nilai_minimal = :nilaiMin ")
        List<ListSekolah> findSekolahByNilai(@Param("nilaiMin") Float nilaiMin);

}
