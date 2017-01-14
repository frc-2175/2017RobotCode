#!/bin/bash
FILES=src/properties/competitionbot/*
c=""
for f in $FILES
do
	c="$c $f"
done
scp $c admin@roborio-2175-frc.local:/home/lvuser
ssh admin@roborio-2175-frc.local "killall -q netconsole-host || :"
