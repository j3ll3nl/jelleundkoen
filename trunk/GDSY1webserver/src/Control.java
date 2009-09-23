
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import java.net.*;
import javax.swing.*;



public class Control implements ActionListener,ItemListener {
    private Thread thread = null;
	private Server server = null;

    private InetAddress host;
    private int port;
    public static String contentbase;
    private String logs;

    private MyJFrame Gui;

    public Control(){
        Gui = new MyJFrame(this);
        Gui.setVisible(true);
    }

    public void doStart() throws Exception{
        try{

            InetAddress[] adreslijst = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

            // Om te testen -----
            server = new Server((InetAddress) Gui.hostCombobox.getSelectedItem(), Integer.parseInt(Gui.portField.getText()), Gui.contentbaseField.getText());
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

        if(e.getSource() == Gui.actionButton){
            if(Gui.actionButton.getText() == "Start")
            {
                Gui.actionButton.setText("Stop");
                Gui.actionButton.setBackground(Color.RED);
                try {
                doStart();
                } catch (Exception ex) {
                log(ex.getMessage());
                } 
            }
            else if(Gui.actionButton.getText() == "Stop"){
                Gui.actionButton.setText("Start");
                Gui.actionButton.setBackground(Color.GREEN);
                try {
                doStop();
                } catch (Exception ex) {
                log(ex.getMessage());
                }
            }

        }
        
        if(e.getSource() == Gui.portField){
            System.out.println(e.getActionCommand());
        }
        
    }

    public void itemStateChanged(ItemEvent e) {        
    }
}