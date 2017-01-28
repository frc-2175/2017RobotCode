pscp -pw "" src\properties\practicebot\*.properties admin@roborio-2175-frc.local:/home/lvuser
plink -ssh -pw "" admin@roborio-2175-frc.local "mkdir -m 775 -v log; killall -q netconsole-host || :"
