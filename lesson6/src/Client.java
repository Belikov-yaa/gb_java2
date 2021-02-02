import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String IP_ADDRESS = "localhost";
    static final int PORT = 8189;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(IP_ADDRESS, PORT)) {
            System.out.println("Connected to the server");
            Scanner sc = new Scanner(System.in);

            try (DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())) {

                Thread reader = new Thread(() -> {
                    while (true) {
                        try {
                            outputStream.writeUTF(sc.nextLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                reader.setDaemon(true);
                reader.start();

                while (true) {
                    String msg = inputStream.readUTF();

                    if (msg.startsWith("/end")) {
                        outputStream.writeUTF("/end");
                        System.out.println("Server disconnected");
                        break;
                    }

                    System.out.format("Server: %s\n", msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
