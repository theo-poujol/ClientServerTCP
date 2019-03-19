import java.io.*;
import java.net.Socket;

public class TaskServeurEcho implements Runnable {
    Socket client;

    public TaskServeurEcho(Socket client) {
        this.client = client;
    }


    @Override
    public void run() {
        String chaine;

        try {

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while((chaine = br.readLine()) != null) {
                bw.write(chaine.toUpperCase());
                bw.newLine();
                bw.flush();
            }

            bw.close();
            br.close();
            client.close();

        }

        catch(IOException e) {
            e.printStackTrace();
        }

    }
}
