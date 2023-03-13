import java.io.*;
import java.net.*;

public class EchoServer {
    private static final int PORT = 34522;

    public static void main(String[] args) throws IOException {
        System.out.println("Сервер запущен и готов к работе... " + "\n");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = server.accept(); // accept a new client
                     DataInputStream input = new DataInputStream(socket.getInputStream()); DataOutputStream output = new DataOutputStream(socket.getOutputStream())

                ) {

                    String msg = input.readUTF(); // read a message from the client
                    output.writeUTF(msg); // resend it to the client
                    System.out.println("К нам пришел " + msg + "\n");

                    Integer a = 1;
                    while (true) {
                        String msg1 = input.readUTF();
                        if (msg1.equals("bye")) break;
                        output.writeUTF(a + " - " + msg1); // resend it to the client
                        System.out.println("Получено cоюбие No" + a + " - " + msg1);
                        a++;

                    }
                }

            }
        }
    }
}
