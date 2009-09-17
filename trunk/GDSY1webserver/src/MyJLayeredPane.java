import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

class MyJLayeredPane extends JLayeredPane implements MouseWheelListener{
    private static final long serialVersionUID = 1L;

    private Control control;

    private JScrollPane MyJScrollPane;
    private JTextPane MyJTextPane;

    MyJLayeredPane(Control c){
        control = c;
        setName("MyLayeredPane");
        addMouseWheelListener(this);

        addNewLayer();
    }

    public void addNewLayer(){
        MyJTextPane = new JTextPane();
        MyJTextPane.setBackground(Color.WHITE);
        MyJTextPane.setSize(900, 200);
        MyJTextPane.setText("Blah");
        
        MyJScrollPane = new JScrollPane();
        MyJScrollPane.setBounds(0, 35, 899, 200);
        MyJScrollPane.setSize(899, 200);
        MyJScrollPane.add(MyJTextPane);
        
        add(MyJScrollPane, JLayeredPane.DEFAULT_LAYER);

    }

    public void mouseWheelMoved(MouseWheelEvent mwe){
        int rotation = mwe.getWheelRotation();
        int top = getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER);
        Component[] component = getComponentsInLayer(JLayeredPane.DEFAULT_LAYER);
        if (rotation > 0)
        {
            moveToBack(component[0]);
        }
        else
        {
            moveToFront(component[top-1]);
        }
    }
}
