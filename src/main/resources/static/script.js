function getDiagnosis() {
    let inputElement = document.getElementById("symptomInput");
    if (!inputElement) {
        console.error("Element with ID 'symptomInput' not found!");
        return;
    }

    let symptoms = inputElement.value.split(",").map(s => s.trim());

    fetch("http://localhost:9090/api/diagnose", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ symptoms: symptoms })
    })
    .then(response => response.json())
    .then(data => {
        let resultDiv = document.getElementById("result");
        if (!resultDiv) {
            console.error("Element with ID 'result' not found!");
            return;
        }
        
        resultDiv.innerHTML = `
            <p><strong>Diagnosis:</strong> ${data.diagnosis}</p>
            <p><strong>Treatment:</strong> ${data.treatment}</p>
        `;
    })
    .catch(error => console.error("Error:", error));
}
