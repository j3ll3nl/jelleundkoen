
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    private Socket serverSocket;
    private String contentbase;

    public Service(Socket sk, String contentbase) throws Exception {
        serverSocket = sk;
        this.contentbase = contentbase;

        SocketInputStream input = new  SocketInputStream(serverSocket.getInputStream());
		Request request = new Request(input);
	    System.out.println(request);
        
        Servlet svlt = new Servlet(this.contentbase);
        
        OutputStream os = serverSocket.getOutputStream();
        os.write(svlt.service(request).getBytes());
        os.write(svlt.service(request).getEntityBody());
        os.close();

    }

    public void closeSocket(){
        
    }

    public void run() {
        
    }

}
