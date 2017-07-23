@echo off
title Building ForageCraft...
echo Building ForageCraft...
echo.
cd ..
call gradlew.bat build
cd setup
echo.
pause
exit /b