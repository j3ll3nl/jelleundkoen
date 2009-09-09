
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    private Socket serverSocket;
    private String link;

    public Service(Socket sk, String l) throws Exception {
        serverSocket = sk;
        link = l;
    }

    public void closeSocket(){
        
    }

    public void run() {
        
    }

}
