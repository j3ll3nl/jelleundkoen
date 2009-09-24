
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Control implements ActionListener, ItemListener {

    private Thread thread = null;
    private Server server = null;
    public static String contentbase;
    public String logs;
    private ArrayList<MyJScrollPane> ScrollPanes;
    private MyJFrame Gui;
    

    public Control() {

        ScrollPanes = new ArrayList<MyJScrollPane>();
        Gui = new MyJFrame(this);
        Gui.setVisible(true);

        log(1, "");

    }

    public void doStart() throws Exception {
        log(0, "De webserver is gestart.");
        log(1, "doStart()");
        try {
            server = new Server((InetAddress) Gui.hostCombobox.getSelectedItem(), Integer.parseInt(Gui.portField.getText()), Gui.contentbaseField.getText());
            log(1, server.toString());
            thread = new Thread(server);
            log(1, thread.toString());
            thread.start();
            log(1, "De Thread is gestart");
        } catch (Exception e) {
            log(0, e.getMessage());
        }

    }

    public void doStop() {
        log(0, "De webserver is gestopt.");
        try {

            server.close();

        } catch (IOException e) {
            log(0, e.getMessage());
        }
    }

    public void log(int i, String message) {
        if (i > 0) {
            try {
                MyJScrollPane scrollPane = ScrollPanes.get(i - 1);
                scrollPane.MyJTextPane.append(message);
            } catch (IndexOutOfBoundsException e) {
                MyJScrollPane scrollPane = new MyJScrollPane(i);
                scrollPane.MyJTextPane.setText(message);
                ScrollPanes.add(scrollPane);
                Gui.layeredPane.addInLayer(scrollPane);
            }
        } else {
            Gui.errorLable.setText(message);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Gui.actionButton) {
            if (Gui.actionButton.getText().equals("Start")) {
                Gui.actionButton.setText("Stop");
                Gui.actionButton.setBackground(Color.RED);
                try {
                    doStart();
                } catch (Exception ex) {
                    log(0, ex.getMessage());
                }
            } else if (Gui.actionButton.getText().equals("Stop")) {
                Gui.actionButton.setText("Start");
                Gui.actionButton.setBackground(Color.GREEN);
                try {
                    doStop();
                } catch (Exception ex) {
                    log(0, ex.getMessage());
                }
            }

        }

        if (e.getSource() == Gui.portField) {
            System.out.println(e.getActionCommand());
        }

    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Gui.hostCombobox) {
            log(0, "Host is gewijzigd in '" + e.getItem() + "'");
        }
    }
}
