
import javax.swing.JFrame;



public class Gui extends JFrame{

    private Control control;

    public Gui(Control c){
        control = c;

        createGui();
    }

    public void createGui(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
}
