import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by vitiok on 9/14/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String message;
        String messageFromServer;

        Socket clientSocket = new Socket("localhost",4000);
        System.out.println("Client socket is open...");
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type message for the server: ");
        message = inFromUser.readLine();
        outToServer.writeBytes(message + '\n');
        messageFromServer = inFromServer.readLine();

        System.out.println("SERVER: " + messageFromServer);

        clientSocket.close();
    }
}
