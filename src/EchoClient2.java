import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient2 {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Who are You?");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();

            output.writeUTF(msg); // send a message to the server
            String receivedMsg = input.readUTF(); // read the reply from the server

            System.out.println("Hello, " + receivedMsg);


            while(true){
                String msg1 = scanner.nextLine();
                output.writeUTF(msg1); // send a message to the server
                if(msg1.equals("bye")) break;
                String receivedMsg1 = input.readUTF(); // read the reply from the server
                System.out.println("Ответ сервера: "+ receivedMsg1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}