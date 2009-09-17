
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class MyGlassPane extends JComponent {
    private static final long serialVersionUID = 1L;
    private Font font = new Font("monospaced", Font.PLAIN, 50);

    private Control control;

    public int number = 1;

    MyGlassPane(Control c)
    {
        control = c;
        setName("MyGlassPane");
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D LayerNumber = (Graphics2D)g;
        LayerNumber.setFont(font);
        LayerNumber.setColor(Color.BLUE);
        LayerNumber.drawString("- "+number+" -", 700, 100);
    }

}
