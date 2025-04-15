package com.example.medicaldiagnosis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DiagnosisController {

    private static final Map<List<String>, String> diagnosisRules = new HashMap<>();
    private static final Map<String, String> treatmentRecommendations = new HashMap<>();

    static {
        // Define diagnosis rules
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
        diagnosisRules.put(Arrays.asList("itching", "rash", "blisters"), "Chickenpox");
        diagnosisRules.put(Arrays.asList("joint pain", "stiffness", "swelling"), "Arthritis");
        diagnosisRules.put(Arrays.asList("chest pain", "shortness of breath", "nausea"), "Heart Attack");
        diagnosisRules.put(Arrays.asList("difficulty breathing", "wheezing", "coughing"), "Asthma");
        diagnosisRules.put(Arrays.asList("frequent urination", "burning sensation", "cloudy urine"), "Urinary Tract Infection (UTI)");
        diagnosisRules.put(Arrays.asList("yellowing skin", "fatigue", "abdominal pain"), "Hepatitis");
        diagnosisRules.put(Arrays.asList("unexplained weight loss", "increased hunger", "frequent urination"), "Diabetes Mellitus");
        diagnosisRules.put(Arrays.asList("memory loss", "confusion", "difficulty speaking"), "Alzheimer's Disease");
        diagnosisRules.put(Arrays.asList("tremors", "slow movement", "muscle stiffness"), "Parkinson's Disease");
        diagnosisRules.put(Arrays.asList("dry cough", "fever", "loss of taste or smell"), "COVID-19");
        diagnosisRules.put(Arrays.asList("fever", "swollen lymph nodes", "muscle aches"), "Mononucleosis");
        diagnosisRules.put(Arrays.asList("severe headache", "stiff neck", "sensitivity to light"), "Meningitis");
        diagnosisRules.put(Arrays.asList("nausea", "vomiting", "dizziness"), "Vertigo");
        diagnosisRules.put(Arrays.asList("chronic diarrhea", "abdominal pain", "weight loss"), "Crohn's Disease");
        diagnosisRules.put(Arrays.asList("fatigue", "weight gain", "cold intolerance"), "Hypothyroidism");
        diagnosisRules.put(Arrays.asList("weight loss", "heat intolerance", "palpitations"), "Hyperthyroidism");
        diagnosisRules.put(Arrays.asList("blurred vision", "eye pain", "halos around lights"), "Glaucoma");
        diagnosisRules.put(Arrays.asList("fever", "parotid gland swelling", "muscle aches"), "Mumps");
        diagnosisRules.put(Arrays.asList("fever", "red eyes", "rash"), "Measles");
        diagnosisRules.put(Arrays.asList("fever", "salmon-colored rash", "sore throat"), "Scarlet Fever");
        diagnosisRules.put(Arrays.asList("painful urination", "lower abdominal pain", "abnormal discharge"), "Chlamydia");
        diagnosisRules.put(Arrays.asList("genital sores", "painful urination", "flu-like symptoms"), "Herpes");
        diagnosisRules.put(Arrays.asList("genital warts", "itching", "discomfort"), "Human Papillomavirus (HPV)");
        diagnosisRules.put(Arrays.asList("fever", "headache", "stiff neck"), "Encephalitis");
        diagnosisRules.put(Arrays.asList("fatigue", "joint pain", "butterfly-shaped facial rash"), "Lupus");
    
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
        treatmentRecommendations.put("Chickenpox", "Apply calamine lotion, take antihistamines for itching, and get plenty of rest.");
        treatmentRecommendations.put("Asthma", "Use an inhaler as prescribed, avoid allergens, and stay in a well-ventilated space.");
        treatmentRecommendations.put("Heart Attack", "Seek emergency medical help, chew aspirin, and try to stay calm.");
        treatmentRecommendations.put("UTI", "Drink cranberry juice, take prescribed antibiotics, and stay hydrated.");
        treatmentRecommendations.put("Hepatitis", "Follow a balanced diet, avoid alcohol, and take prescribed antiviral medications.");
        treatmentRecommendations.put("Parkinson's Disease", "Take prescribed medications, engage in physical therapy, and maintain a healthy diet.");
        treatmentRecommendations.put("COVID-19", "Isolate, take paracetamol for fever, stay hydrated, and seek medical help if breathing issues occur.");
        treatmentRecommendations.put("Meningitis", "Seek emergency medical care, take antibiotics if bacterial, and rest in a quiet, dark room.");
        treatmentRecommendations.put("Vertigo", "Avoid sudden movements, take prescribed vestibular suppressants, and stay hydrated.");
        treatmentRecommendations.put("Glaucoma", "Use prescribed eye drops, avoid excessive screen time, and get regular eye check-ups.");
        treatmentRecommendations.put("Depression", "Seek therapy, engage in physical activities, and follow a healthy sleep routine.");
        treatmentRecommendations.put("Insomnia", "Maintain a consistent sleep schedule, avoid caffeine late in the day, and practice relaxation techniques.");
    
    }
    

    @PostMapping("/diagnose")
    public ResponseEntity<Map<String, String>> diagnose(@RequestBody SymptomsRequest request) {
        if (request == null || request.getSymptoms() == null || request.getSymptoms().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Symptoms list cannot be empty"));
        }

        List<String> userSymptoms = request.getSymptoms();
        System.out.println("Received Symptoms: " + userSymptoms);

        // AI Logic: Find the best-matching disease
        String bestMatchDisease = "Unknown Disease";
        String treatment = "Consult a doctor for further evaluation.";
        int maxMatchCount = 0;

        for (Map.Entry<List<String>, String> entry : diagnosisRules.entrySet()) {
            List<String> symptoms = entry.getKey();
            String disease = entry.getValue();

            int matchCount = 0;
            for (String symptom : userSymptoms) {
                if (symptoms.contains(symptom)) {
                    matchCount++;
                }
            }

            // Find the disease with the highest number of matched symptoms
            if (matchCount > maxMatchCount) {
                maxMatchCount = matchCount;
                bestMatchDisease = disease;
                treatment = treatmentRecommendations.getOrDefault(disease, "Consult a doctor.");
            }
        }

        // Prepare response
        Map<String, String> response = new HashMap<>();
        response.put("diagnosis", bestMatchDisease);
        response.put("treatment", treatment);

        return ResponseEntity.ok(response);
    }

    // DTO class to hold the JSON request data
    static class SymptomsRequest {
        private List<String> symptoms;

        public List<String> getSymptoms() {
            return symptoms;
        }

        public void setSymptoms(List<String> symptoms) {
            this.symptoms = symptoms;
        }
    }
}
