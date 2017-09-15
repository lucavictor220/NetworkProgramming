import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vitiok on 9/14/17.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        String clientSentence;
        boolean isStopped = false;

        ServerSocket serverSocket = new ServerSocket(4000);
        while (!isStopped) {
            System.out.println("Server is waiting for connection...");
            Socket connectionSocket = serverSocket.accept();

            new Thread(new Worker(connectionSocket)).start();
        }

        serverSocket.close();
    }
}
