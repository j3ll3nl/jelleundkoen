import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JLayeredPane;

class MyJLayeredPane extends JLayeredPane implements MouseWheelListener{
    private static final long serialVersionUID = 1L;

    private Control control;

    MyJLayeredPane(Control c){
        control = c;
        setName("MyLayeredPane");

        add(new MyJPanel(control), JLayeredPane.DEFAULT_LAYER);
        

        addMouseWheelListener(this);
    }

    addNewLayer(){
        add(new MyJPanel(control), JLayeredPane.DEFAULT_LAYER);
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
