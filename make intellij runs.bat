@echo off
title Waiting...
echo Before continuing, make sure IntelliJ IDEA is open on your workspace, and do not close it until after the batch script has finished.
pause
title Generating run files for IntelliJ IDEA...
call gradlew.bat genIntellijRuns
echo Now that the runs have been generated, go back to IntelliJ IDEA and when a pop-up asks you to refresh the workspace, please do so.
pause
exit /b