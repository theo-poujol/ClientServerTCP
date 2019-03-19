import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class ClientTcpEcho {

    private String hostname;
    private int port;

    /**
     * Constructeur
     * @param hostname
     * @param port
     */
    public ClientTcpEcho(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }


    public void lancerBW() {

        try {


            Socket socketClient = new Socket();

            socketClient.connect(new InetSocketAddress(this.hostname,this.port));
            System.out.println("Connection : Success...");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));


            while(true) {




                Scanner scanner = new Scanner(System.in);
                System.out.printf("Veuillez saisir un message : ");

                String message = scanner.nextLine();

                bw.write(message);
                bw.newLine();
                bw.flush();

                String writtenLine = br.readLine();



                if ( writtenLine != null) {

                    if (writtenLine.equals("QUIT") || writtenLine.equals("quit")) {
                        bw.close();
                        br.close();
                        socketClient.close();
                        System.out.println("Deconnexion : Success...");;
                        break;

                    }

                    else {
                        System.out.println("Vous avez écrit : ");
                        System.out.println(writtenLine);

                    }
                }



            }

        }

        catch(IOException e) {
            e.printStackTrace();
        }

    }
}
