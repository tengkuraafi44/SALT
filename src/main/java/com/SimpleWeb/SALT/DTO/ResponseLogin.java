package com.SimpleWeb.SALT.DTO;

import com.SimpleWeb.SALT.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLogin implements Serializable, ResponseData {

    private String status;
    private String roles;
}
