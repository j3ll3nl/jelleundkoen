
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

class MyContentPane extends JPanel{
    private static final long serialVersionUID = 1L;

    MyContentPane()
    {
        System.out.println("MyContentPane()");
        setName("MyContentPane");
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(1, 1));
    }
}
