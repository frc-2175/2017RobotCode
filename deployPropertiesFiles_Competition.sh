::Shared Files
scp -pw "" src\properties\* admin@roborio-2175-frc.local:/home/lvuser
::Bot Specified Files
scp -pw "" src\properties\competitionbot\* admin@roborio-2175-frc.local:/home/lvuser
::SSH files to robot
plink -ssh -pw "" admin@roborio-2175-frc.local "mkdir -m 775 -v log; killall -q netconsole-host || :"
