package org.usfirst.frc.team2175;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class NetConsoleReceiver {
	
	private static Thread listener;
	
	public static DatagramSocket makeRecvSocket() {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(null);
			socket.setReuseAddress(true);
			socket.bind(new InetSocketAddress(6666));
		} catch (SocketException e) {
			e.printStackTrace();
			socket.close();
			return null;
		}
		return socket;
	}
	
	public static byte[] getPacket(DatagramSocket socket, DatagramPacket buf) {
		try {
			socket.receive(buf);
		} catch (IOException e) {
			return null;
		}
		byte[] ret = new byte[buf.getLength()];
		System.arraycopy(buf.getData(), 0, ret, 0, ret.length);
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		listener = new Thread(new Runnable() {
			@Override
			public void run() {
				DatagramSocket socket = makeRecvSocket();
				if (socket == null)
					return;
				byte[] buf = new byte[4096];
				DatagramPacket datagram = new DatagramPacket(buf, buf.length);
				while (!Thread.interrupted()) {
					byte[] s = getPacket(socket, datagram);
					if (s != null) {
						String msg = new String(s);
						System.out.print(msg);
						
						if (msg.indexOf("********** Robot program starting **********") > -1) {
							exit(0, "Robot program started successfully!");
						}
						if (msg.indexOf("ERROR: Could not instantiate robot org.usfirst.frc.team2175.robot.Robot!") > -1) {
							exit(1, "Robot program failed to start!");
						}
					}
				}
				socket.close();
			}
		}, "Netconsole-Listener");
		listener.start();
		
		// Wait for enter key
		System.in.read();
		listener.interrupt();
	}
	
	public static void exit(int code, String message) {
		listener.interrupt();
		System.out.println();
		System.out.println(message);
		System.exit(code);
	}

}
