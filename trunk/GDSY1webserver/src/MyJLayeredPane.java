
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyJLayeredPane extends JLayeredPane implements MouseWheelListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private int layersize = 1;

    public MyJLayeredPane() {
        setName("MyLayeredPane");
        addMouseWheelListener(this);
    }

    public void addInLayer(MyJScrollPane p) {
        add(p, JLayeredPane.DEFAULT_LAYER);
    }

    public void mouseWheelMoved(MouseWheelEvent mwe) {
        MyJRootPane MyRootpane = (MyJRootPane) getParent();

        int rotation = mwe.getWheelRotation();
        int top = getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER);
        Component[] component = getComponentsInLayer(JLayeredPane.DEFAULT_LAYER);
        if (rotation > 0) {
            moveToBack(component[0]);
            layersize = (layersize == top) ? 1 : ++layersize;
        } else {
            layersize = (layersize == 1) ? top : --layersize;
            moveToFront(component[top - 1]);
        }

        MyRootpane.setGlassPane(new MyGlassPane(layersize));
        MyRootpane.createGlassPane();
        MyRootpane.updateUI();


    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
    }
}
