
import java.awt.Dimension;
import javax.swing.JTextPane;

public class MyJTextPane extends JTextPane{
    public MyJTextPane(){
        setPreferredSize(new Dimension(900, 400));
    }

    public void append(String message){
        message = getText()+"\n"+message;
        setText(message);
    }
}
