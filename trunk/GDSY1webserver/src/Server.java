
import java.io.*;
import java.net.*;

public class Server extends ServerSocket implements Runnable {
    private String contentbase;

    public Server(InetAddress h, int p, String c) throws IOException{
        super(p,50, h);
        this.contentbase = c;
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
				new Thread(new Service(serverSocket,contentbase)).start();
			}
		}
		catch(SocketException e)
		{
			System.out.println("Een fout in de socket:" + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
