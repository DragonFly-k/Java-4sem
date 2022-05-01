package Socket;
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    public BufferedReader In;
    public PrintWriter Out;

    public Server() throws IOException {
        serverSocket = new ServerSocket(8000);
        System.out.println("Сервер запущен");
        while (true) {
            socket = serverSocket.accept();
            ServerThread st = new ServerThread(socket);
            new Thread(st).start();
        }
    }

    class ServerThread implements Runnable {
        private Socket socket;
        private int randomNumber;
        int clientNumber = 0;

        public ServerThread(Socket s) throws IOException {
            socket = s;
            In = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Out = new PrintWriter(socket.getOutputStream());
        }

        public void run() {
            System.out.println("Клиент подключился");
            randomNumber = (int) (Math.random() * 100);
            System.out.println("Загаданное число:" + randomNumber);
            try {
                clientNumber = Integer.parseInt(In.readLine());
                for (int i = 3; i > 1; i--) {
                    if (clientNumber == randomNumber) {
                        Out.println("ПОЗДРАВЛЯЕМ, число угадано");
                        Client.finished = true;
                    } else if (clientNumber < randomNumber) {
                        Out.println("Число слишком маленькое, у вас еще есть " + (i - 1) + " попытка(и)");
                        Client.finished = false;
                    } else if (clientNumber > randomNumber) {
                        Out.println("Число слишком большое, у вас все еще есть " + (i - 1) + " попытка(и)");
                        Client.finished = false;
                    }
                    Out.flush();
                    if (!Client.finished) {
                        clientNumber = Integer.parseInt(In.readLine());
                    } else {
                        break;
                    }
                }
                if (!Client.finished) {
                    Out.println("УВЫ у вас 0 попыток, игра окончена");
                }
                Client.finished = true;
            } catch (IOException e) {
            } finally {
                try {
                    Out.close();
                    In.close();
                    socket.close();
                } catch (IOException ee) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}