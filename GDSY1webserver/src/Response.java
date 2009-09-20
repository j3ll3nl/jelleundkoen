
import java.text.SimpleDateFormat;
import java.util.*;

public class Response extends HashMap<String, String> {

    private String statusLine;
    private String generalHeader;
    private String responseHeader;
    private String entityHeader;
    private byte[] entityBody;

    public Response(){}

    public byte[] getBytes(){
        this.setGeneralHeader();
        this.setResponseHeader();
        this.setEntityHeader();

        String fullResponse = "";

        // Response opbouwen door informatie aan elkaar te plakken.
        // Status-Line*( General-Header| Response-Header| Entity-Header ) CRLF[ Entity-Body ]
        fullResponse = this.getStatusLine() + "\n" +  this.getGeneralHeader() + "\n" + this.getResponseHeader() + "\n" + this.getEntityHeader() + "\n\n";
                //"( " + this.getGeneralHeader() + "| " + this.getResponseHeader() + "| " + this.getEntityHeader() +
                //" \n\r" + this.getEntityBody() + "";

        System.out.println(fullResponse);
        System.out.println(this.getEntityBody());
        return fullResponse.getBytes();

    }

    public void setStatusLine(String statusCode, String reasonPhrase) {
        this.statusLine = "HTTP/1.10 " + statusCode + " " + reasonPhrase + " ";
    }

    public void setStatusLine(String statusCode) {
        this.statusLine = "HTTP/1.1 " + statusCode + " reason unknown ";
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    public void setGeneralHeader() {
        Date d = new Date();
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("EEE, d MMM yyyy H:mm:ss",Locale.UK);

        // add HTTPdate
        this.generalHeader = "Date: " + formatter.format(d) + " GMT";// Tue, 15 Nov 1994 08:12:31 GMT;
    }

    public String getGeneralHeader() {
        return this.generalHeader;
    }
    public void setResponseHeader() {
        this.responseHeader = "Server: 1337SERV/0.1";
    }

    public String getResponseHeader() {
        return this.responseHeader;
    }

    public void setEntityHeader() {
        this.entityHeader = "Allow: GET, HEAD";
    }

    public String getEntityHeader() {
        return this.entityHeader;
    }
    
    public void setEntityBody(byte[] s) {
        this.entityBody = s;
    }

    public byte[] getEntityBody() {
        return this.entityBody;
    }
}
