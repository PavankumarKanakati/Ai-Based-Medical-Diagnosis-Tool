@echo off
echo 🚀 Starting backend...
start cmd /c "cd /d C:\Users\pavan\OneDrive\Desktop\my health checker && mvn spring-boot:run"

timeout /t 5 > nul

echo 🌐 Opening frontend...
start "" "C:\Program Files\Google\Chrome\Application\chrome.exe" "C:\Users\pavan\OneDrive\Desktop\my health checker\src\main\resources\static\first.html"

pause
