import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Servlet {
    public Response response;
    public String contentbase;
    public Request request;

    public Servlet(String contentbase){
        this.contentbase = contentbase;

        this.response = new Response();
    }

    public Response service(Request r){
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
        this.response.setStatusLine("501");
    }

    public void DELETE() {
        this.response.setStatusLine("501");
    }

    public void GET() {
        String filename = !(this.request.getRequestURI().equals("/")) ? ""+request.getRequestURI() : "index.html";
        File file = new File(this.contentbase + filename);

        if (file.exists()) {
            byte[] body;
        
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

                body = new byte[bis.available()];
                bis.read(body);

                this.response.setStatusLine("200", "OK");
                this.response.setEntityBody(body);

            } catch (IOException e) {
                e.printStackTrace();
                this.response.setStatusLine("501", "IOException");
            }
        } else {
            // file bestaat niet
            this.response.setStatusLine("404", "File not found");
        }
    }

    public void HEAD() {
        this.response.setStatusLine("501", "Not Implemented");
    }

    public void OPTIONS() {
        this.response.setStatusLine("501", "Not Implemented");
    }

    public void POST() {
        this.response.setStatusLine("501", "Not Implemented");
    }

    public void PUT() {
        this.response.setStatusLine("501", "Not Implemented");
    }

    public void TRACE() {
        this.response.setStatusLine("501", "Not Implemented");
    }
}
