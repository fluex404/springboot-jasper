package com.fluex404.springbootjasper.service;

import com.fluex404.springbootjasper.model.Employe;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;

@Service
public class ReportService {

    public ByteArrayInputStream exportPdfResport() throws Exception{
        List<Employe> employes = getEmployes();

        // load file and compile it
        File file = ResourceUtils.getFile("classpath:Simple_Blue.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employes);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("subTitle", "Isa Subani");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        byte[] pdfByte=  JasperExportManager.exportReportToPdf(jasperPrint);

        return new ByteArrayInputStream(pdfByte);
    }

    List<Employe> getEmployes(){
        List<Employe> employes = new ArrayList<>();
        for(int i=100;i<200;i++) {
            Employe e = new Employe(i, "Test "+i, (i+5000));

            employes.add(e);
        }

        return employes;
    }
}
