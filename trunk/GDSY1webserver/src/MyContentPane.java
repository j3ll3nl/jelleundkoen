
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
    public MyJPanel MyJPanel;

    MyContentPane()
    {
        System.out.println("MyContentPane()");
        setName("MyContentPane");
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,3));
        setPreferredSize(new Dimension(900, 400));

        MyJPanel = new MyJPanel();

        add(MyJPanel);

    }
}
