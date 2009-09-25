
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    private Control control;
    private Socket serverSocket;
    private String contentbase;
    private Server server;

    public Service(Control contr,Server s,Socket sk, String contentbase) throws Exception {
        serverSocket = sk;
        this.contentbase = contentbase;
        this.server = s;
        this.control = contr;

        // Zorgt dat de Server thread hem kent.
        this.server.addservice(this,Thread.currentThread());

        SocketInputStream input = new  SocketInputStream(serverSocket.getInputStream());
		Request request = new Request(control,input);
	    control.log(1,""+request);
        
        Servlet svlt = new Servlet(control,this.contentbase);
        
        OutputStream os = serverSocket.getOutputStream();

        //System.out.println("Content" + content.toString());

        os.write(svlt.service(request).getBytes());

        //os.write(head);
        //os.write(body);
        os.close();

        this.closeSocket();
    }

    public void closeSocket(){
        control.log(1,"Socket gesloten");
        this.server.removeService(this);
        control.log(1,"Service afgesloten");

    }

    public void run() {
        
    }

}
