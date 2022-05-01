package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class GMessage {
    private final DatagramSocket socket;
    private final byte[] messageUDP = new byte[7];

    public GMessage(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void getM() throws IOException {
        socket.receive(new DatagramPacket(messageUDP, 7));
        var message = new String(messageUDP);
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        GMessage get = new GMessage(4444);
        while (true)
            get.getM();
    }
}
