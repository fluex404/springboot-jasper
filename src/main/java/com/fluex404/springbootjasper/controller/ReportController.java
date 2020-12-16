package com.fluex404.springbootjasper.controller;

import com.fluex404.springbootjasper.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;


@RestController
@RequestMapping("/api/pdf")
public class ReportController {

    @Autowired
    ReportService service;

    @GetMapping("/download")
    @CrossOrigin(exposedHeaders = {"Content-Disposition", "testName"})
    public ResponseEntity<InputStreamResource> download() throws Exception{
        ByteArrayInputStream in = service.exportPdfResport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=test.pdf");

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
}
