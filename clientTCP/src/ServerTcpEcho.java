import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ServerTcpEcho {

    private String hostname;
    private int port;
    private int nbClient;

    public ServerTcpEcho(String hostname, int port, int nbClient) {
        this.hostname = hostname;
        this.port = port;
        this.nbClient = nbClient;
    }


    public void launchServer() {


        try {

            ServerSocket socketServer = new ServerSocket(this.port);
            Socket socketClient;

            BufferedWriter bw;
            BufferedReader br;

            String writtenLine;

            for (int i = 0; i < this.nbClient; i++) {

                socketClient = socketServer.accept();
                System.out.println("Connection : Success...");

                bw = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));


                writtenLine = br.readLine();

                while (writtenLine != null) {
                    bw.write(writtenLine);
                    bw.newLine();
                    bw.flush();
                }
                br.close();
                bw.close();
                socketClient.close();

            }

            socketServer.close();
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }


}
