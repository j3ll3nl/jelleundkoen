
import java.text.SimpleDateFormat;
import java.util.*;

public class Response extends HashMap<String, String> {

    private String statusLine;
    private String generalHeader;
    private String responseHeader;
    private String entityHeader;
    private String contentType;
    private byte[] entityBody;

    public Response(){}

    public byte[] getBytes(){
        this.setGeneralHeader();
        this.setResponseHeader();
        this.setEntityHeader();

        String fullResponse = "";

        fullResponse = this.getStatusLine() + "\n" +  this.getGeneralHeader() + "\n" + this.getResponseHeader() + "\n" + this.getEntityHeader() + "\n" + this.contentType + "\nContent-Length:" + this.getEntityBody().length;
        fullResponse += (this.getEntityBody() != null) ? "\n\n" : "";

        System.out.println(fullResponse);
        System.out.println(new String(this.getEntityBody()));

        byte[] head = fullResponse.getBytes();
        byte[] body = getEntityBody();

        byte[] content = new byte[head.length + body.length];

        int c = 0;

        for (byte h : head) {
            content[c] = h;
            c++;
        }

        for (byte b : body) {
            content[c] = b;
            c++;
        }

        return content;

    }

    public void setStatusLine(String statusCode, String reasonPhrase) {
        this.statusLine = "HTTP/1.1 " + statusCode + " " + reasonPhrase + " ";
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
        this.generalHeader = "Date:" + formatter.format(d) + " GMT";// Tue, 15 Nov 1994 08:12:31 GMT;
    }

    public String getGeneralHeader() {
        return this.generalHeader;
    }
    public void setResponseHeader() {
        this.responseHeader = "Server:1337SERV/0.1";
    }

    public String getResponseHeader() {
        return this.responseHeader;
    }

    public void setEntityHeader() {
        this.entityHeader = "Allow:GET,HEAD";
    }

    public String getEntityHeader() {
        return this.entityHeader;
    }
    
    public void setEntityBody(byte[] s, String filetype) {
        this.contentType = "Content-Type:" + filetype;
        this.entityBody = s;
    }

    public byte[] getEntityBody() {
        return this.entityBody;
    }
}
