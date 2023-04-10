package com.SimpleWeb.SALT.controller;

import com.SimpleWeb.SALT.DTO.InquiryResponse;
import com.SimpleWeb.SALT.DTO.InquiryResponseSekolah;
import com.SimpleWeb.SALT.DTO.ResponseLogin;
import com.SimpleWeb.SALT.Response;
import com.SimpleWeb.SALT.Services.InquiryDataService;
import com.SimpleWeb.SALT.Services.InquiryListSekolah;
import com.SimpleWeb.SALT.Services.LoginServices;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ahp/dss")
@OpenAPIDefinition(info = @Info(
        title = "Collection API",
        description = "API to perform Collection",
        version = "1.0.0"
)
)
@AllArgsConstructor
public class InquiryController {
    @Autowired
    InquiryDataService inquiryDataService;

    @Autowired
    InquiryListSekolah inquiryListSekolah;

    @Autowired
    LoginServices loginServices;


    @ResponseBody
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get Data From table Konsumen")
    @Tag(name = "Inquiry Data")
    @ApiResponse(responseCode = "200", description = "Get Recent Activity Savings", content = @Content(schema = @Schema(implementation = InquiryResponse.class)))
    public ResponseEntity getData(
            @RequestParam(value = "id", required = true) String customerId) {

        final InquiryResponse inquiryResponse = inquiryDataService.findDataByParam(customerId);


        return ResponseEntity.ok().body(inquiryResponse);
    }

    @ResponseBody
    @GetMapping(value = "/kampus", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get Data From table sekolah")
    @Tag(name = "Inquiry sekolah")
    @ApiResponse(responseCode = "200", description = "Get Recent Activity Savings", content = @Content(schema = @Schema(implementation = Response.class)))
    public ResponseEntity getDataSekolah(
            @RequestParam(value = "namaSiswa", required = true) String namaSiswa,
            @RequestParam (value = "nilai", required = true) Float nilai) throws Exception {

        final InquiryResponseSekolah inquiryResponse = inquiryListSekolah.findSekolah(namaSiswa,nilai);

        final Response response = new Response();
        response.setData(inquiryResponse);
        response.addResponseStatus("00","Success");



        return ResponseEntity.ok().body(response);
    }

    @ResponseBody
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "For Login")
    @Tag(name = "Login")
    @ApiResponse(responseCode = "200", description = "Login Activity", content = @Content(schema = @Schema(implementation = Response.class)))
    public ResponseEntity LoginPost(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam (value = "password", required = true) String password) throws Exception {

        final ResponseLogin responseLogin = loginServices.login(username,password);
        final Response response = new Response();
        response.setData(responseLogin);
        response.addResponseStatus("00","Success");



        return ResponseEntity.ok().body(response);
    }
}
