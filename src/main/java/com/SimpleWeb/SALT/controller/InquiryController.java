package com.SimpleWeb.SALT.controller;

import com.SimpleWeb.SALT.DTO.InquiryResponse;
import com.SimpleWeb.SALT.Services.InquiryDataService;
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
@RequestMapping(value = "/salt/test")
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



    @ResponseBody
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get Data From table Konsumen")
    @Tag(name = "Inquiry Data")
    @ApiResponse(responseCode = "200", description = "Get Recent Activity Savings", content = @Content(schema = @Schema(implementation = InquiryResponse.class)))
    public ResponseEntity getData(
            @RequestParam(value = "id",required = true) String customerId) {

        final InquiryResponse inquiryResponse = inquiryDataService.findDataByParam(customerId);


        return ResponseEntity.ok().body(inquiryResponse);
    }
}
