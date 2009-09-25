
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server extends ServerSocket implements Runnable {
    private String contentbase;
    private HashMap<Service,Thread> services;
    private Control control;

    public Server(Control contr,InetAddress h, int p, String c) throws IOException{
        super(p,50, h);
        this.contentbase = c;
        this.control = contr;
    }

    public boolean isAlive(){
        if(isAlive()){
            return true;
        }
        return false;
    }

    public void removeServive(){
        control.log(1,"removeService()");
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
				new Thread(new Service(control,this,serverSocket,contentbase)).start();
			}
		}
		catch(SocketException e)
		{
			control.log(1,"Een fout in de socket:" + e.getMessage());
		}
		catch(Exception e)
		{
			control.log(1,e.getMessage());
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
      control.log(1,"Thread wordt gesloten");
      for (Service s: this.services.keySet()) {
            Thread t = this.services.get(s);

            if (t.isAlive())
                t.interrupt();
            this.removeService(s);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        control.log(1,"Server gefinalized.");
    }
}
