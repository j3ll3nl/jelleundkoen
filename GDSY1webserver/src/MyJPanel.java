import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

            contentbaseField = new JTextField("C:/eenbestand die ik nu nog niet kan benoemen");
            contentbaseField.setName("contentbaseField");
            this.add(contentbaseField);

            actionButton = new JButton("Start");
            actionButton.setBackground(Color.GREEN);
            actionButton.setName("actionButton");
            this.add(actionButton);


        } catch (UnknownHostException ex) {
            Logger.getLogger(MyJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}