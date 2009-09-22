
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class MyContentPane extends JPanel{
    private static final long serialVersionUID = 1L;

    private MyJRootPane rootPane;
    public MyJLayeredPane layeredPane;

    private JPanel MyJPanel;
    private JLabel hostLable,portLable,contentbaseLable,ErrorLable;
    public JComboBox hostCombobox;
    public JTextField portField,contentbaseField;
    public JButton actionButton;

    MyContentPane()
    {
        System.out.println("MyContentPane()");
        setName("MyContentPane");
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,3));
        setPreferredSize(new Dimension(900, 400));

            MyJPanel = new JPanel();

            MyJPanel.setLayout(new FlowLayout());
            MyJPanel.setSize(900, 35);

            hostLable = new JLabel();
            hostLable.setName("hostLable");
            MyJPanel.add(hostLable);
            hostLable.setText("Host: ");

            InetAddress[] adress = null;
        try {
            adress = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {}

            ComboBoxModel hostListModel = new DefaultComboBoxModel(adress);
            hostCombobox = new JComboBox();
            hostCombobox.setName("host");
            MyJPanel.add(hostCombobox);
            hostCombobox.setModel(hostListModel);
            hostCombobox.setSelectedItem(adress);
            //hostCombobox.addItemListener(control);

            portLable = new JLabel();
            portLable.setName("portLable");
            MyJPanel.add(portLable);
            portLable.setText("Port: ");

            portField = new JTextField("1337");
            portField.setName("portField");
            MyJPanel.add(portField);
            portField.setColumns(4);

            contentbaseLable = new JLabel();
            contentbaseLable.setName("contentbaseLable");
            MyJPanel.add(contentbaseLable);
            contentbaseLable.setText("ContentBase: ");

            contentbaseField = new JTextField("C:/"); // Nu kan je bij de contentbase Control.contentbase
            contentbaseField.setName("contentbaseField");
            MyJPanel.add(contentbaseField);
            contentbaseField.setColumns(23);

            actionButton = new JButton("Start");
            actionButton.setBackground(Color.GREEN);
            actionButton.setName("actionButton");
            MyJPanel.add(actionButton);

        add(MyJPanel);

    }
}
