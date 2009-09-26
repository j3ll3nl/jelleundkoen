
import java.net.Socket;
import java.io.*;


public class Service implements Runnable{

    public Control control;
    private Socket serverSocket;
    private String contentbase;
    private Server server;
    private int serviceLogNr;

    public Service(Control contr,Server s,Socket sk, String contentbase) throws Exception {
        if (Main.debug) System.out.println("Debug: Service Constructor"); //debug regel die alleen weergegeven word als Main.debug op true staat
        
        serverSocket = sk;
        this.contentbase = contentbase;
        this.server = s;
        this.control = contr;

        // Zorgt dat de Server thread hem kent.
        this.server.addservice(this,Thread.currentThread());

        SocketInputStream input = new  SocketInputStream(serverSocket.getInputStream());
		Request request = new Request(control,input);

	    serviceLogNr = control.log(""+request+"\n");
        request.addServiceLogNr(serviceLogNr);
        
        Servlet svlt = new Servlet(control,serviceLogNr,this.contentbase);
        
        OutputStream os = serverSocket.getOutputStream();

        //System.out.println("Content" + content.toString());

        os.write(svlt.service(request).getBytes());

        //os.write(head);
        //os.write(body);
        os.close();

        this.closeSocket();
    }

    public void closeSocket(){
        control.log(this.serviceLogNr,"Socket gesloten");
        this.server.removeService(this);
        control.log(this.serviceLogNr,"Service afgesloten");

    }

    public void run() {
        
    }

}
