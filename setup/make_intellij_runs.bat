@echo off
title Waiting...
echo Before continuing, make sure IntelliJ IDEA is open on your workspace, and do not close it until after the batch script has finished.
pause
echo.
title Generating run files for IntelliJ IDEA...
echo Generating run files for IntelliJ IDEA...
echo.
cd ..
call gradlew.bat genIntellijRuns
cd setup
echo.
echo Now that the runs have been generated, go back to IntelliJ IDEA. If a pop-up asks you to refresh the workspace, please do so.
echo Make sure to edit configurations so the run file is set to have _main in it.
pause
exit /b