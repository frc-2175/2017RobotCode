pscp -pw "" src\properties\practicebot\*.properties admin@roborio-2175-frc.local:/home/lvuser
plink -ssh -pw "" admin@roborio-2175-frc.local "killall -q netconsole-host || :"
