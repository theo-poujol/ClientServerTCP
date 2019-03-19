import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ClientTcpEcho clientTcpEcho = new ClientTcpEcho("10.203.9.145",50007);
//        clientTcpEcho.lancerBW();

//        ServerTcpEcho serverTcpEcho = new ServerTcpEcho("10.203.9.145",50007,50);
//        serverTcpEcho.launchServer();

        ServerTcpMulti serverTcpMulti = new ServerTcpMulti(50007,50);
        serverTcpMulti.launchServer();

    }
}