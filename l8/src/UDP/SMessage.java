package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SMessage {
    private DatagramSocket socket;

    public SMessage(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void sendM(String messages, int port) throws IOException {
        DatagramPacket message = new DatagramPacket(messages.getBytes(), messages.getBytes().length, InetAddress.getLocalHost(), port);
        socket.send(message);
    }

    public static void main(String[] args) throws IOException {
        SMessage udp = new SMessage(8080);
        udp.sendM("Hello !", 4444);
        System.out.println("Сообщение отправлено");
    }

}
