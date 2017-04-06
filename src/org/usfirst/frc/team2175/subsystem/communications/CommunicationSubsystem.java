package org.usfirst.frc.team2175.subsystem.communications;

import org.usfirst.frc.team2175.subsystem.BaseSubsystem;

public class CommunicationSubsystem extends BaseSubsystem {
    private UDPServer udpServer;

    public CommunicationSubsystem() {
        // change port number to be read from the property files
        // make sure it is one that frc allows
        udpServer = new UDPServer(5808);
    }

    public double getSetpoint() {
        return udpServer.getSetpoint();
    }

}
