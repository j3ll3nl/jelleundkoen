
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.IOException;

class SocketInputStream
extends FilterInputStream
{
  SocketInputStream(InputStream is)
  {
    super(is);
  }
  String readLine() // a line ends with CRLF !
  throws IOException
  {
    int c1 = read();
    if (c1 == -1) throw new IOException("eof");

    int c2 = read();
    if (c2 == -1) throw new IOException("line error (1)");

    String ret = "";
    while (c1 != '\r' || c2 != '\n')
    {
      ret = ret + (char)c1;
      c1 = c2;
      c2 = read();
      if (c2 == -1) throw new IOException("line error (2)");
    }
    return ret.equals("") ? null : ret;
  }
}
