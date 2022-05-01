package Socket;
import java.io.*;
import java.net.*;

public class Client {

    private Socket socket;
    private BufferedReader In;
    private PrintWriter Out;
    private BufferedReader console;
    static Boolean finished = false;

    public Client() throws IOException {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8000);
            console = new BufferedReader(new InputStreamReader(System.in));
            In = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Out = new PrintWriter(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.err.println("Не удается подключиться к серверу");
            System.exit(-1);
        }
        System.out.println("Соединение установлено");

        if (finished) {
            System.out.println("Соединение закрыто");
        }

        while (!finished) {
            System.out.println("Пожалуйста, введите число от 0 до 100");
            Out.println(console.readLine());
            Out.flush();
            String str = In.readLine();
            System.out.println(str);
            if (str == null || str.startsWith("УВЫ") || str.startsWith("ПОЗДРАВЛЯЕМ")) {
                finished = true;
                break;
            }
        }
        In.close();
        Out.close();
        console.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}