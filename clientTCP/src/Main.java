import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ClientTcpEcho clientTcpEcho = new ClientTcpEcho("10.203.9.145",50007);
        clientTcpEcho.lancerBW();

    }
}