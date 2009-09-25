import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Servlet {
    public Control control;
    public Response response;
    public String contentbase;
    public Request request;


    public Servlet(Control contr,String contentbase){
        if (Control.debug) System.out.println("Servlet 1"); // Word alleen getoond als de debug var in Control op true staat
        this.control = contr;
        this.contentbase = contentbase;

        this.response = new Response(this.control);
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
        String filename = getFileName();

        File file = new File(this.contentbase + filename);

        String filetype = getFileType(filename);

        if (file.exists()) {
            byte[] body;
        
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

                body = new byte[bis.available()];
                bis.read(body);

                this.response.setStatusLine("200", "OK");
                this.response.setEntityBody(body, filetype);

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
        String filename = getFileName();
        File file = new File(this.contentbase + filename);

        String filetype = getFileType(filename);

        if (file.exists()) {

            this.response.setStatusLine("200", "OK");
            this.response.setEntityBody(null, filetype);
        } else {
            // file bestaat niet
            this.response.setStatusLine("404", "File not found");
        }
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

    public String getFileType(String filename) {
        String filetype = filename.substring(filename.lastIndexOf("."));

        if (filetype.equalsIgnoreCase(".html"))
            filetype = "text/" + filetype.substring(1);
        else if (filetype.equalsIgnoreCase(".htm"))
            filetype = "text/" + filetype.substring(1);
        else if (filetype.equalsIgnoreCase(".jpg"))
            filetype = "image/" + filetype.substring(1);
        else if (filetype.equalsIgnoreCase(".gif"))
            filetype = "image/" + filetype.substring(1);
        else if (filetype.equalsIgnoreCase(".png"))
            filetype = "image/" + filetype.substring(1);
        else filetype = "text/plain";

        return filetype;
    }

    public String getFileName() {
        String filename = this.request.getRequestURI();

        if (filename.equals("/"))
            return "index.html";

        int i = filename.lastIndexOf("?");
        if (i == -1)
            return filename;

        return filename.substring(0,i);
    }

    @Override
    protected void finalize() throws Throwable {
        control.log(1,"Servlet gefinalized.");
    }
}
