@echo off
title Decompiling Minecraft and setting up Eclipse workspace...
echo Decompiling Minecraft and setting up Eclipse workspace...
echo.
cd ..
call gradlew.bat setupDecompWorkspace
call gradlew.bat eclipse
cd setup
echo.
pause
exit /b