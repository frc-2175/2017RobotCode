package org.usfirst.frc.team2175.subsystem.communications;

/**
Java ECHO server with UDP sockets example
*/
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    DatagramSocket sock = null;
    private double setpoint;
    private static int defaultPortNum = 7777;

    public static void main(String args[]) {
        new UDPServer();
    }

    public UDPServer() {
        this(defaultPortNum);
    }

    public UDPServer(int port) {

        try {
            // 1. creating a server socket, parameter is local port number
            sock = new DatagramSocket(port);

            // buffer to receive incoming data
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

            // 2. Wait for an incoming data
            echo("Server socket created. Waiting for incoming data...");

            new Thread(() -> {
                processMessage(incoming);
            }).start();

        } catch (IOException e) {
            System.err.println("IOException " + e);
        }
    }

    public void processMessage(DatagramPacket incoming) {
        try {
            // communication loop
            while (!Thread.interrupted()) {
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());

                //
                // This code is not robust - it should make sure the parameter
                // passed in is a double
                boolean isDouble = false;
                setpoint = 0.0;

                try {
                    setpoint = Double.parseDouble(s);
                    isDouble = true;
                } catch (Exception e) {
                    // TODO: handle exception
                }

                if (isDouble) {
                    // TurnDegreesWithGyroCommand command =
                    // new TurnDegreesWithGyroCommand(setpoint);
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

    // simple function to echo data to terminal
    public static void echo(String msg) {
        System.out.println(msg);
    }

    public double getSetpoint() {
        return setpoint;
    }

}
