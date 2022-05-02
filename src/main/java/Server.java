import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server started!..");
        int port = 8089;
        var serverSocket = new ServerSocket(port);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            var out = new PrintWriter(clientSocket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("New connection accepted: Port %d%n", clientSocket.getPort());
            final String name = in.readLine();
            out.println(String.format("Welcome, %s, your port is %d", name, clientSocket.getPort()));
        }
    }
}
