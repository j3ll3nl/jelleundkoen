
import javax.swing.JRootPane;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class MyJRootPane extends JRootPane {
  private static final long serialVersionUID = 1L;

  private Control control;

  public MyJRootPane(Control c)
  {
    control = c;
    setName("MyJRootPane");
  }

  @Override
  protected Component createGlassPane()
  {
    return new MyGlassPane(control);
  }

  @Override
  protected JLayeredPane createLayeredPane()
  {
    return new MyJLayeredPane(control);
  }

  @Override
  protected Container createContentPane()
  {
    return new MyContentPane(control);
  }
}
