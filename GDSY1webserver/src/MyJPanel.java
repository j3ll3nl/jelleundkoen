import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class MyJPanel extends JPanel{
    private static final long serialVersionUID = 1L;

    private JLabel hostLable,portLable,contentbaseLable,ErrorLable;
    private JComboBox hostCombobox;
    private JTextField portField,contentbaseField;
    private JButton actionButton;


    MyJPanel(){
        try {
            setLayout(new FlowLayout());
            setSize(900, 35);

            JRootPane rootPane = getRootPane();

            hostLable = new JLabel();
            hostLable.setName("hostLable");
            this.add(hostLable);
            hostLable.setText("Host: ");
            
            
            InetAddress[] adress = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
            ComboBoxModel hostListModel = new DefaultComboBoxModel(adress);
            hostCombobox = new JComboBox();
            hostCombobox.setName("host");
            this.add(hostCombobox);
            hostCombobox.setModel(hostListModel);
            hostCombobox.setSelectedItem(adress);
            //hostCombobox.addItemListener(control);

            portLable = new JLabel();
            portLable.setName("portLable");
            this.add(portLable);
            portLable.setText("Port: ");

            portField = new JTextField("1337");
            portField.setName("portField");
            this.add(portField);

            contentbaseLable = new JLabel();
            contentbaseLable.setName("contentbaseLable");
            this.add(contentbaseLable);
            contentbaseLable.setText("ContentBase: ");

            contentbaseField = new JTextField("C:/eenbestand die ik nu nog niet kan benoemen"); // Nu kan je bij de contentbase Control.contentbase
            contentbaseField.setName("contentbaseField");
            this.add(contentbaseField);

            actionButton = new JButton("Start");
            actionButton.setBackground(Color.GREEN);
            actionButton.setName("actionButton");
            this.add(actionButton);
            //actionButton.addActionListener((ActionListener) rootPane.getLayeredPane());

        } catch (UnknownHostException ex) {
        }

    }


}