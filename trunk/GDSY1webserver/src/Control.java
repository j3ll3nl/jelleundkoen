
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;



public class Control {
    private Thread thread = null;
	private Server server = null;

    private InetAddress host;
    private int port;
    private String contentbase;
    private String logs;

    public Control(){
        try {
            doStart();

        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    public void doStart() throws Exception{
        try{

            InetAddress[] adreslijst = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

            // Om te testen -----
            host = adreslijst[0];
            port = 1337;
            contentbase = "c:";
            System.out.println(host);

            server = new Server(host, port, contentbase);
            thread = new Thread(server);
            thread.start();
        }
        catch(Exception e){
            log(e.getMessage());
        }

    }

    public void doStop(){
        try {
            
            server.close();

        } catch (IOException e) {
            log(e.getMessage());
        }
    }

    public void log(String m){
        logs += "\n"+m;
    }
}
