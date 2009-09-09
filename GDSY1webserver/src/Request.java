
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

		String[] inputSplit = requestline.split(" ");
		method = inputSplit[0];
		uri = inputSplit[1];
		version = inputSplit[2];

		String lijn = "";
		while ((lijn=socketInputStream.readLine()) != null)
		{
			String[] header = lijn.split(":",2);
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
