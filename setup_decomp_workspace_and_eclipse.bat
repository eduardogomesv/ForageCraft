@echo off
title Decompiling Minecraft and setting up Eclipse workspace...
call gradlew.bat setupDecompWorkspace eclipse
pause
exit /b
