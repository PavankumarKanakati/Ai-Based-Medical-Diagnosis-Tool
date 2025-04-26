@echo off
<<<<<<< HEAD
echo 🔥 Starting My Health Checker with bundled JRE...
=======
echo 🔥 Starting My Health Checker with bundled JRE... Please Wait...
>>>>>>> 700ee257729cf11ddf30926d3fbc2c4bfa1e60a0

:: Set the path to the local JRE folder
set JAVA_HOME=%~dp0jre

:: Start backend using the bundled Java
start "" /MIN "%JAVA_HOME%\bin\java.exe" -jar "%~dp0target\demo-0.0.1-SNAPSHOT.jar"

:: Wait a few seconds for the backend to start (adjust if needed)
timeout /t 8 > nul

:: Open the frontend in the browser (served by Spring Boot)
start "" "http://localhost:9090/first.html"

exit
