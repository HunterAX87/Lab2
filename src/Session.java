import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



class Session extends Thread {
    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    public void run() {
        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            String msg=input.readUTF();
            output.writeUTF(msg);
            System.out.println(msg+" подключился ");
            Integer a = 1;
            while (true) {
                String msg1 = input.readUTF();
                if (msg1.equals("bye")) break;
                output.writeUTF(a + " - " + msg1); // resend it to the client
                System.out.println("Получено cоюбие No" + a + " - " + msg1);
                a++;

            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}