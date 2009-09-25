
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server extends ServerSocket implements Runnable {
    private String contentbase;
    private HashMap<Service,Thread> services;

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
				new Thread(new Service(this,serverSocket,contentbase)).start();
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

    public void addservice(Service s,Thread t) {
        this.services.put(s, t);
    }

    public void removeService(Service s) {
        this.services.remove(s);
    }

    public boolean threadsClosed() {
        for (Service s: this.services.keySet()) {
            Thread t = this.services.get(s);

            if (t.isAlive())
                return false;
        }
        return true;
    }

    public void closeThreads() {
      for (Service s: this.services.keySet()) {
            Thread t = this.services.get(s);

            if (t.isAlive())
                t.interrupt();
            this.removeService(s);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Server gefinalized.");
    }
}
