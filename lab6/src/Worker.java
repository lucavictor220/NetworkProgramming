import java.io.*;
import java.net.Socket;

/**
 * Created by vitiok on 9/15/17.
 */
public class Worker implements Runnable {

    private Socket client;
    private PhoneServer phoneServer;

    public Worker(Socket client, PhoneServer phoneServer) {
        this.client = client;
        this.phoneServer = phoneServer;
    }

    public void run() {
        String clientMessage;
        String serverResponse;

        try {
            InputStream socketInputStream = client.getInputStream();
            InputStreamReader socketInputStreamReader = new InputStreamReader(socketInputStream);
            BufferedReader inFromClient = new BufferedReader(socketInputStreamReader);
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());

            clientMessage = inFromClient.readLine();
            Thread.sleep(5000);
            System.out.println(clientMessage);
            serverResponse = phoneServer.processPhoneNumber(clientMessage);
            System.out.println(serverResponse);

            System.out.println("Received: " + serverResponse);
            outToClient.writeBytes(serverResponse + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
