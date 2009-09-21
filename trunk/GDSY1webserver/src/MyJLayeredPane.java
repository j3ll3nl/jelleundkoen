import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyJLayeredPane extends JLayeredPane implements MouseWheelListener,ActionListener{
    private static final long serialVersionUID = 1L;

    private JScrollPane MyJScrollPane;
    private JTextPane MyJTextPane;
    private int layer = 1;

    private MyJRootPane rootpane;
    private MyContentPane contentPane;

    public MyJLayeredPane(){
        setName("MyLayeredPane");
        addMouseWheelListener(this);

        contentPane = new MyContentPane();

        rootpane = (MyJRootPane) getRootPane();
        rootpane.setContentPane(contentPane);

        addNewLayer("De Output van deel 1...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        addNewLayer("De Output van deel 2...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        addNewLayer("De Output van deel 3...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        addNewLayer("De Output van deel 4...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        addNewLayer("De Output van deel 5...\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    public void addNewLayer(String s){
        MyJTextPane = new JTextPane();
        MyJTextPane.setText(s);

        MyJScrollPane = new JScrollPane(MyJTextPane);
        MyJScrollPane.setBounds(3, 35, 890, 300);
        
        add(MyJScrollPane, JLayeredPane.DEFAULT_LAYER);

    }

    public void mouseWheelMoved(MouseWheelEvent mwe){
        MyJRootPane MyRootpane = (MyJRootPane) getParent();

        int rotation = mwe.getWheelRotation();
        int top = getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER);
        Component[] component = getComponentsInLayer(JLayeredPane.DEFAULT_LAYER);
        if (rotation > 0)
        {
            moveToBack(component[0]);
            layer = (layer ==top)? 1 :++layer;
        }
        else
        {
            layer = (layer ==1)? top :--layer;
            moveToFront(component[top-1]);
        }

        MyRootpane.setGlassPane(new MyGlassPane(layer));
        MyRootpane.createGlassPane();
        MyRootpane.updateUI();
        

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
