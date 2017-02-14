::Shared Files
pscp -pw "" src\properties\* admin@roborio-2175-frc.local:/home/lvuser
::Bot Specified Files
pscp -pw "" src\properties\practicebot\* admin@roborio-2175-frc.local:/home/lvuser
::SSH files to robot
plink -ssh -pw "" admin@roborio-2175-frc.local "mkdir -m 775 -v log; killall -q netconsole-host || :"
