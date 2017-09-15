import java.io.*;
import java.net.Socket;

/**
 * Created by vitiok on 9/15/17.
 */
public class Worker implements Runnable {

    private Socket client;

    public Worker(Socket client) {
        this.client = client;
    }

    public void run() {
        String clientSentence;
        try {
            InputStream socketInputStream = client.getInputStream();
            InputStreamReader socketInputStreamReader = new InputStreamReader(socketInputStream);
            BufferedReader inFromClient = new BufferedReader(socketInputStreamReader);
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());

            clientSentence = inFromClient.readLine();
            Thread.sleep(10000);

            System.out.println("Received: " + clientSentence);
            outToClient.writeBytes("Got it\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
