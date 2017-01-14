@echo off

rem See "IP Lists" on page https://wpilib.screenstepslive.com/s/4485/m/13503/l/242608?data-resolve-url=true&data-manual-id=13503

echo Determine connectivity to RoboRIO using ping.


echo.
echo.
echo Trying with DNS name (Ethernet or USB connection)
ping roboRIO-2175-FRC.local


echo.
echo.
echo Trying with IP (USB connection)
ping 172.22.11.2


echo.
echo.
echo Trying Robot Radio
ping 10.21.75.1

pause
