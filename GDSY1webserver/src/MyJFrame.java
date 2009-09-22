
import javax.swing.*;

public class MyJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public Control control;

    private JRootPane MyRootPane;
    private MyContentPane contentPane;
    public MyJLayeredPane layeredPane;

    public JComboBox hostCombobox;
    public JTextField portField,contentbaseField;
    public JButton actionButton;

    public MyJFrame(Control c){
        control = c;
        
        setName("Webserver");
        setTitle("Webserver");
        setResizable(false);
        setBounds(10, 10, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getGlassPane().setVisible(true);

        contentPane = (MyContentPane) getContentPane();
        layeredPane = (MyJLayeredPane) getLayeredPane();

        hostCombobox = contentPane.hostCombobox;
        portField = contentPane.portField;
        contentbaseField = contentPane.contentbaseField;
        actionButton = contentPane.actionButton;

        hostCombobox.addItemListener(control);
        portField.addActionListener(control);
        contentbaseField.addActionListener(control);
        actionButton.addActionListener(control);

        actionButton.addItemListener(control);

    }

    @Override
    protected JRootPane createRootPane()
    {
        return new MyJRootPane(this);
    }

}
