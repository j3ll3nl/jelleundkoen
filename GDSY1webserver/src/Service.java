
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    private Socket serverSocket;
    private String link;

    public Service(Socket sk, String l) throws Exception {
        serverSocket = sk;
        link = l;

        SocketInputStream input = new  SocketInputStream(serverSocket.getInputStream());
		Request request = new Request(input);
	    System.out.println(request);

    }

    public void closeSocket(){
        
    }

    public void run() {
        
    }

}
