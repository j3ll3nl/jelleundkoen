
import java.io.IOException;
import java.util.*;



public class Request extends HashMap<String, String> {

	private String method=null;
	private String uri=null;
	private String version=null;
    private SocketInputStream socketInputStream;

	public Request(SocketInputStream sis) throws IOException
	{


        socketInputStream = new SocketInputStream(sis);

		String requestline = socketInputStream.readLine();
		String[] splitline = requestline.split(" ");
		method = splitline[0];
		uri = splitline[1];
		version = splitline[2];
		// nu de headers
		String line = "";
		while ((line=socketInputStream.readLine()) != null)
		{
			String[] header = line.split(":",2);
			put(header[0], header[1]);
		}
    
	}

	public String getMETHOD()
	{
		return method;
	}

	public String getRequestURI()
	{
		return uri;
	}

	public String getVERSION()
	{
		return version;
	}
}
