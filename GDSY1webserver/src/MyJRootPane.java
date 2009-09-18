
import javax.swing.JRootPane;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;

public class MyJRootPane extends JRootPane {
  private static final long serialVersionUID = 1L;

  private MyJFrame frame;

  public MyJRootPane(MyJFrame f)
  {
    frame = f;
    setName("MyJRootPane");
  }

  @Override
  protected Component createGlassPane()
  {
    return new MyGlassPane();
  }

  @Override
  protected JLayeredPane createLayeredPane()
  {
    return new MyJLayeredPane();
  }
  @Override
  protected Container createContentPane()
  {
    return new MyContentPane(frame);
  }
}
