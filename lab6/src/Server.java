import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vitiok on 9/14/17.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        String clientSentence;

        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server is waiting for connection...");
        Socket connectionSocket = serverSocket.accept();
        InputStream socketInputStream = connectionSocket.getInputStream();
        InputStreamReader socketInputStreamReader = new InputStreamReader(socketInputStream);
        BufferedReader inFromClient = new BufferedReader(socketInputStreamReader);
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        clientSentence = inFromClient.readLine();

        System.out.println("Received: " + clientSentence);
        outToClient.writeBytes("Received, thx");

        connectionSocket.close();
        serverSocket.close();
    }
}
