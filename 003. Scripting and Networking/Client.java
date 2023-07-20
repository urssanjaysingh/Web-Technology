import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hello server!";
            out.println(message);
            System.out.println("Sent message to server: " + message);

            String response = in.readLine();
            System.out.println("Response from server: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
