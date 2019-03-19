import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcpMulti {




        private int port;
        private int nbClient;

    public ServerTcpMulti(int port, int nbClient) {
        this.port = port;
        this.nbClient = nbClient;
    }


    public void launchServer() {

            try {

                ServerSocket socketServer = new ServerSocket(this.port);
                System.out.println("Serveur TCP multi threadé lancé sur le port " + this.port);
                Socket socketClient;

                for (int i = 0; i < this.nbClient; i++) {
                    socketClient = socketServer.accept();
                    TaskServeurEcho task = new TaskServeurEcho(socketClient);
                    Thread thread = new Thread(task);
                    thread.start();


                }

                socketServer.close();
            }

            catch(IOException e) {
                e.printStackTrace();
            }
        }




}
