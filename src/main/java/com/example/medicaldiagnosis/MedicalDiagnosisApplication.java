package com.example.medicaldiagnosis;  // Change according to your package name

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "AI Medical Diagnosis API",
        version = "1.0",
        description = "API for medical diagnosis application"
))
@SpringBootApplication
public class MedicalDiagnosisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalDiagnosisApplication.class, args);
    }
}
