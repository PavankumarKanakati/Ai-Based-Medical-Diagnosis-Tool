function showHealthFact() {
    const facts = [
        "Your heart beats around 100,000 times a day! ❤️",
        "Laughing is good for your heart and boosts blood flow by 20%! 😂",
        "Drinking water can increase your energy levels by 30%! 💧",
        "A daily 30-minute walk can reduce heart disease risk by 40%! 🚶‍♂️",
        "Your brain uses 20% of the oxygen you breathe! 🧠"
    ];
    let randomFact = facts[Math.floor(Math.random() * facts.length)];
    document.getElementById("healthFact").innerText = randomFact;
}
