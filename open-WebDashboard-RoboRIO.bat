@echo off

setlocal

set BROWSER="C:\Program Files\Internet Explorer\iexplore"

echo Opening RoboRIO WebDashboard using DNS name (Ethernet connection)
%BROWSER% http://roboRIO-2175-FRC.local

echo Opening RoboRIO WebDashboard using IP (USB connection)
%BROWSER% http://172.22.11.2

endlocal

pause
