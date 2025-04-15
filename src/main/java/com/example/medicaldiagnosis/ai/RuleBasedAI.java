package com.example.medicaldiagnosis.ai;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class RuleBasedAI {
    
    private final Map<List<String>, String> diagnosisRules = new HashMap<>();
    private final Map<String, String> treatmentRecommendations = new HashMap<>();

    public RuleBasedAI() {
        // Define rules for diagnosis
        diagnosisRules.put(Arrays.asList("fever", "cough", "headache"), "Flu");
        diagnosisRules.put(Arrays.asList("sore throat", "runny nose"), "Common Cold");
        diagnosisRules.put(Arrays.asList("fever", "body ache", "fatigue"), "Dengue");
        diagnosisRules.put(Arrays.asList("rash", "joint pain", "fever"), "Chikungunya");
        diagnosisRules.put(Arrays.asList("shortness of breath", "chest pain"), "Pneumonia");
        diagnosisRules.put(Arrays.asList("high fever", "chills", "sweating"), "Malaria");
        diagnosisRules.put(Arrays.asList("abdominal pain", "nausea", "vomiting"), "Food Poisoning");
        diagnosisRules.put(Arrays.asList("persistent cough", "night sweats", "weight loss"), "Tuberculosis");
        diagnosisRules.put(Arrays.asList("chest pain", "dizziness", "high blood pressure"), "Hypertension");
        diagnosisRules.put(Arrays.asList("weakness", "blurred vision", "increased thirst"), "Diabetes");
        diagnosisRules.put(Arrays.asList("headache", "nausea", "light sensitivity"), "Migraine");
        diagnosisRules.put(Arrays.asList("stomach pain", "bloating", "diarrhea"), "Irritable Bowel Syndrome (IBS)");
        diagnosisRules.put(Arrays.asList("fatigue", "pale skin", "shortness of breath"), "Anemia");

        // Define treatment recommendations
        treatmentRecommendations.put("Flu", "Rest, stay hydrated, take paracetamol for fever, and consult a doctor if symptoms persist.");
        treatmentRecommendations.put("Common Cold", "Drink warm fluids, get plenty of rest, and use saline nasal spray for congestion.");
        treatmentRecommendations.put("Dengue", "Drink plenty of fluids, avoid aspirin, and monitor for warning signs. Seek medical attention if severe.");
        treatmentRecommendations.put("Chikungunya", "Take pain relievers, apply cold packs to swollen joints, and rest.");
        treatmentRecommendations.put("Pneumonia", "Antibiotics (if bacterial), oxygen therapy if needed, and medical supervision.");
        treatmentRecommendations.put("Malaria", "Take prescribed antimalarial medication, drink fluids, and rest. Seek immediate medical help if symptoms worsen.");
        treatmentRecommendations.put("Food Poisoning", "Stay hydrated, rest, and eat light foods like bananas, rice, applesauce, and toast.");
        treatmentRecommendations.put("Tuberculosis", "Follow the full course of anti-TB medications as prescribed by your doctor.");
        treatmentRecommendations.put("Hypertension", "Reduce salt intake, exercise regularly, take prescribed medications, and monitor blood pressure.");
        treatmentRecommendations.put("Diabetes", "Monitor blood sugar levels, maintain a healthy diet, exercise regularly, and take prescribed medications.");
        treatmentRecommendations.put("Migraine", "Rest in a dark, quiet room, drink plenty of water, and take prescribed pain relief medication.");
        treatmentRecommendations.put("Irritable Bowel Syndrome (IBS)", "Avoid trigger foods, manage stress, and maintain a high-fiber diet.");
        treatmentRecommendations.put("Anemia", "Increase iron intake with foods like spinach, red meat, and take iron supplements if prescribed.");
    }

    public Map<String, String> diagnose(List<String> symptoms) {
        for (Map.Entry<List<String>, String> entry : diagnosisRules.entrySet()) {
            if (symptoms.containsAll(entry.getKey())) {
                String diagnosis = entry.getValue();
                String treatment = treatmentRecommendations.getOrDefault(diagnosis, "Consult a doctor for treatment options.");
                LinkedHashMap<String, String> response = new LinkedHashMap<>();
                response.put("diagnosis", diagnosis);
                response.put("treatment", treatment);
                return response;
            }
        }
        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("diagnosis", "No clear diagnosis");
        response.put("treatment", "Please consult a doctor.");
        return response;
    }
    
}
