
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class MyContentPane extends JPanel{
    private static final long serialVersionUID = 1L;

    private Control control;
    private MyJFrame frame;

    MyContentPane(MyJFrame f)
    {
        frame = f;
        //control = frame.control;
        System.out.println("MyContentPane()");
        setName("MyContentPane");
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,3));
        setPreferredSize(new Dimension(900, 400));

        add(new MyJPanel(control));

    }
}
