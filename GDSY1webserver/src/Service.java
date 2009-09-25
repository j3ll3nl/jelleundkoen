
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    private Socket serverSocket;
    private String contentbase;
    private Server server;

    public Service(Server s,Socket sk, String contentbase) throws Exception {
        serverSocket = sk;
        this.contentbase = contentbase;
        this.server = s;

        // Zorgt dat de Server thread hem kent.
        this.server.addservice(this,Thread.currentThread());

        SocketInputStream input = new  SocketInputStream(serverSocket.getInputStream());
		Request request = new Request(input);
	    System.out.println(request);
        
        Servlet svlt = new Servlet(this.contentbase);
        
        OutputStream os = serverSocket.getOutputStream();

        //System.out.println("Content" + content.toString());

        os.write(svlt.service(request).getBytes());

        //os.write(head);
        //os.write(body);
        os.close();

        this.closeSocket();
    }

    public void closeSocket(){
        System.out.println("Socket gesloten");
        this.server.removeService(this);
        System.out.println("Service afgesloten");

    }

    public void run() {
        
    }

}
