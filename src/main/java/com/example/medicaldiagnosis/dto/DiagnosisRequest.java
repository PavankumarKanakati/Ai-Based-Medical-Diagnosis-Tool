package com.example.medicaldiagnosis.dto;

import java.util.List;

public class DiagnosisRequest {
    private List<String> symptoms;
    

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
