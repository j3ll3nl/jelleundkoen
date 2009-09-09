

public class Servlet {
    public String response;

    public Servlet(){
        this.response =  "test";
    }

    public String service(Request r){
        this.response = "Method: " + r.getMETHOD() + "\n\rgetRequestURI: " + r.getRequestURI() + "\n\rVersion: " + r.getVERSION();
        /*if (r.getMETHOD().equals("GET")) {
            this.response =  "get get get";
        }*/
        return response;
    }
}
