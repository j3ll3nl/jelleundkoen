
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

class MyContentPane extends JPanel{
    private static final long serialVersionUID = 1L;

    private Control control;

    MyContentPane(Control c)
    {
        control = c;
        System.out.println("MyContentPane()");
        setName("MyContentPane");
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1, 1));
    }
}
