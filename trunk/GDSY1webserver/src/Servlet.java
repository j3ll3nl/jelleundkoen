import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Servlet {
    public String response;
    public String contentbase;
    public Request request;

    public Servlet(String contentbase){
        this.response = "";
        this.contentbase = contentbase;
    }

    public String service(Request r){
        this.request = r;
        
        if (r.getMETHOD().equals("CONNECT"))
            this.CONNECT();
        else if (r.getMETHOD().equals("DELETE"))
            this.DELETE();
        else if (r.getMETHOD().equals("GET"))
            this.GET();
        else if (r.getMETHOD().equals("HEAD"))
            this.HEAD();
        else if (r.getMETHOD().equals("OPTIONS"))
            this.OPTIONS();
        else if (r.getMETHOD().equals("POST"))
            this.POST();
        else if (r.getMETHOD().equals("PUT"))
            this.PUT();
        else if (r.getMETHOD().equals("TRACE"))
            this.TRACE();

        return this.response;
    }

    public void CONNECT() {
        this.response = "method not implemented";
    }

    public void DELETE() {
        this.response = "method not implemented";
    }

    public void GET() {
        String filename = !(this.request.getRequestURI().equals("/")) ? ""+request.getRequestURI() : "index.html";
        File file = new File(this.contentbase + filename);

        if (file.exists()) {

            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line;

                while ((line = reader.readLine()) != null) {
                    this.response += line;
                }

                reader.close();
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else this.response = "404 ERROR FILE NOT FOUND";
    }

    public void HEAD() {
        this.response = "method not implemented";
    }

    public void OPTIONS() {
        this.response = "method not implemented";
    }

    public void POST() {
        this.response = "method not implemented";
    }

    public void PUT() {
        this.response = "method not implemented";
    }

    public void TRACE() {
        this.response = "method not implemented";
    }
}
