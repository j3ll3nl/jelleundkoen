
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import javax.swing.JFrame;



public class Control implements ActionListener,ItemListener {
    private Thread thread = null;
	private Server server = null;

    private InetAddress host;
    private int port;
    public static String contentbase;
    private String logs;

    private JFrame Gui;

    public Control(){
        Gui = new MyJFrame(this);
        Gui.setVisible(true);
        
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

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void itemStateChanged(ItemEvent e) {
        System.out.println("item");
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
