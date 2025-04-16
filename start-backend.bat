@echo off
echo 🚀 Starting Spring Boot backend...

:: Navigate to the backend folder and run Spring Boot on any device
start cmd /k "cd /d C:\Users\pavan\OneDrive\Desktop\my health checker 1 && mvn spring-boot:run"

:: Wait for backend to boot
timeout /t 5 > nul

echo 🌐 Opening frontend in browser...
start chrome "http://localhost:9090/first.html"

pause
