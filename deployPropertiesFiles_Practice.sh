#!/bin/bash
FILES=src/properties/practicebot/*
c=""
for f in $FILES
do
	c="$c $f"
done
scp $c admin@roborio-9001-frc.local:/home/lvuser
ssh admin@roborio-9001-frc.local "killall -q netconsole-host || :"
