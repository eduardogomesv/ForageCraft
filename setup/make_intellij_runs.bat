@echo off
title Generating run files for IntelliJ IDEA...
echo Generating run files for IntelliJ IDEA...
echo.
cd ..
call gradlew.bat genIntellijRuns
cd setup
echo.
echo Now that the runs have been generated, go back to IntelliJ IDEA.
echo If a pop-up asks you to refresh the workspace, please do so.
pause
exit /b