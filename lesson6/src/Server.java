import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Socket clientSocket = null;
        Scanner sc = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

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
                        System.out.println("Client disconnected");
                        break;
                    }
                    System.out.format("Client: %s\n", msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
