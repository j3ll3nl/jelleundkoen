
import java.io.*;
import java.net.*;

public class Server extends ServerSocket implements Runnable {
    private String link;

    public Server(String host, int port, String l) throws IOException{
        link = l;
    }

    public boolean isAlive(){
        if(isAlive()){
            return true;
        }
        return false;
    }

    public void removeServive(){
        removeServive();
    }

    public void run()
	{
		try
		{
			while(true)
			{
				System.out.println(this);
				Socket serverSocket = super.accept();
				new Thread(new Service(serverSocket,link)).start();
			}
		}
		catch(SocketException e)
		{
			System.out.println("Een fout in de socket; " + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
