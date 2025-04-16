@echo off
echo 🚀 Starting Health Checker Backend...

:: Start the Spring Boot app using the JAR file
start java -jar target\demo-0.0.1-SNAPSHOT.jar

:: Wait 10 seconds for the backend to boot
timeout /t 10 > nul

echo 🌐 Opening frontend in browser...
start chrome "http://localhost:9090/first.html"

pause
