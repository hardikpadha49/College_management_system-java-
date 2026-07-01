@echo off
mvn clean compile exec:java -Dexec.mainClass="app.Main"
pause
