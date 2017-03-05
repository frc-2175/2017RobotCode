package org.usfirst.frc.team2175.subsystem.communications;

/**
Java ECHO server with UDP sockets example
*/
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.usfirst.frc.team2175.command.single.TurnDegreesWithGyroCommand;

public class UDPServer {
    DatagramSocket sock = null;

    public static void main(String args[]) {
        new UDPServer();
    }

    public UDPServer() {
        this(7777);
    }

    public UDPServer(int port) {

        try {
            // 1. creating a server socket, parameter is local port number
            sock = new DatagramSocket(7777);

            // buffer to receive incoming data
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

            // 2. Wait for an incoming data
            echo("Server socket created. Waiting for incoming data...");
            processMessage(incoming);

        }

        catch (IOException e) {
            System.err.println("IOException " + e);
        }
    }

    // simple function to echo data to terminal
    public static void echo(String msg) {
        System.out.println(msg);
    }

    public void processMessage(DatagramPacket incoming) {
        try {
            // communication loop
            while (true) {
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());

                //
                // Ths code is not robust - it should make sure the parameter
                // passed in is a double
                boolean isDouble = false;
                double setpoint = 0.0;

                try {
                    setpoint = Double.parseDouble(s);

                } catch (Exception e) {
                    // TODO: handle exception
                    isDouble = false;
                }

                if (isDouble) {
                    TurnDegreesWithGyroCommand command =
                            new TurnDegreesWithGyroCommand(setpoint);
                }

                //
                if (false) {
                    // echo the details of incoming data - client ip : client
                    // port -
                    // client message
                    echo(incoming.getAddress().getHostAddress() + " : "
                            + incoming.getPort() + " - " + s);

                    s = "OK : " + s;
                    DatagramPacket dp = new DatagramPacket(s.getBytes(),
                            s.getBytes().length, incoming.getAddress(),
                            incoming.getPort());
                    sock.send(dp);
                }
            }
        } catch (IOException e) {
            System.err.println("IOException " + e);
        }
    }

}
