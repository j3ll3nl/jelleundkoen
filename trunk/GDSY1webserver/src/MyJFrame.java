
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class MyJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public Control control;

    private JRootPane MyRootPane;

    public MyJFrame(Control c){
        control = c;
        
        setName("Webserver");
        setTitle("Webserver");
        setResizable(false);
        setBounds(10, 10, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getGlassPane().setVisible(true);
    }

    @Override
    protected JRootPane createRootPane()
    {
        return new MyJRootPane(this);
    }

}
